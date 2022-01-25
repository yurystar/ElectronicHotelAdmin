package consoleuserinterface.userservice;

public class Navigator {
    Menu currentMenu;

    public void setCurrentMenu(Menu currentMenu) {
        this.currentMenu = currentMenu;
    }

    public void printMenu() {
        System.out.println(currentMenu.getName());
        currentMenu.getMenuItems().forEach(menuItem -> System.out.println(menuItem.getTitle()));
    }

    public void navigate(Integer index) {
        if (currentMenu != null) {
            if (index > -2 && index < currentMenu.getMenuItems().size()) {
                MenuItem menuItem = currentMenu.getMenuItems().get(index);
                menuItem.doAction();
                currentMenu = menuItem.getNextMenu();
            } else System.out.println("Вы вышли за диапазон выбора. Попробуйте еще раз. \n");
        }
    }
}
