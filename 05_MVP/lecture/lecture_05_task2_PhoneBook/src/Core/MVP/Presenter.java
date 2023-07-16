package Core.MVP;

import javax.swing.text.View;
import Core.Models.Contact;

public class Presenter
{
    private Model model;
    private IView view;

    public Presenter(IView view, String pathDb) {
        this.view = view;
        model = new Model(pathDb);
    }

    public void LoadFromFile() {
        model.load();

        if (model.currentBook().count() > 0) {
            model.setCurrentIndex(0);
            var contact = model.currentContact();

            view.setName(contact.getName());
            view.setSurname(contact.getSurname());
            view.setDescription(contact.getDescription());
        }
    }

    public void add()
    {
        Contact contact = new Contact();
        contact.setName(view.getName());
        contact.setSurname(view.getSurname());
        contact.setDescription(view.getDescription());
        model.currentBook().add(contact);
    }

    public void remove() {
        Contact contact = new Contact();
        contact.setName(view.getName());
        contact.setSurname(view.getSurname());
        contact.setDescription(view.getDescription());
        model.currentBook().remove(contact);

        if (model.currentBook().count() < 1) {
            model.setCurrentIndex(-1);

            view.setName("");
            view.setSurname("");
            view.setDescription("");
        } else {
            model.setCurrentIndex(model.getCurrentIndex() - 1);
            if (model.getCurrentIndex() < 0)
                model.setCurrentIndex(0);

            Contact temp = model.currentContact();
            view.setName(temp.getName());
            view.setSurname(temp.getSurname());
            view.setDescription(temp.getDescription());
        }
    }

    public void saveToFile() {
        model.save();
    }

    public void next() {
        if (model.currentBook().count() > 0) {
            if (model.getCurrentIndex() + 1 < model.currentBook().count()) {
                model.setCurrentIndex(model.getCurrentIndex() + 1);
                Contact contact = model.currentContact();
                view.setName(contact.getName());
                view.setSurname(contact.getSurname());
                view.setDescription(contact.getDescription());
            }
        }
    }

    public void prev() {
        if (model.currentBook().count() > 0) {
            if (model.getCurrentIndex() - 1 > -1) {
                model.setCurrentIndex(model.getCurrentIndex() - 1);
                Contact contact = model.currentContact();
                view.setName(contact.getName());
                view.setSurname(contact.getSurname());
                view.setDescription(contact.getDescription());
            }
        }
    }
}
