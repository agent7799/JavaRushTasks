package com.javarush.task.task36.task3608;

import com.javarush.task.task36.task3608.controller.Controller;
import com.javarush.task.task36.task3608.model.MainModel;
import com.javarush.task.task36.task3608.model.Model;
import com.javarush.task.task36.task3608.view.EditUserView;
import com.javarush.task.task36.task3608.view.UsersView;

public class Solution {
    public static void main(String[] args) {
       Model model = new MainModel();
        UsersView usersView = new UsersView();

        //В классе Solution перед методом fireEventOpenUserEditForm(126L), надо создать новый
        // объект EditUserView, затем передать его контроллеру.
        EditUserView editUserView = new EditUserView();

        Controller controller = new Controller();

        usersView.setController(controller);
        //для editUserView тоже нужно указать controller
        editUserView.setController(controller);


        controller.setModel(model);
        controller.setUsersView(usersView);
        controller.setEditUserView(editUserView);


        usersView.fireEventShowAllUsers();
        usersView.fireEventOpenUserEditForm(126L);
        editUserView.fireEventUserDeleted(124L);
        editUserView.fireEventUserChanged("Novichok", 123L, 5);
        usersView.fireEventShowDeletedUsers();

    }
}