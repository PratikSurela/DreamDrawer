package pratiksurela.com.dreamdrawer.Drawer;

public class DrawerItem {
    private int icon,white_icon;
    private String title;

    public DrawerItem(int icon, int white_icon, String title) {
        this.icon = icon;
        this.white_icon = white_icon;
        this.title = title;
    }

    public int getWhite_icon() {
        return white_icon;
    }

    public void setWhite_icon(int white_icon) {
        this.white_icon = white_icon;
    }

    public int getIcon() {
        return icon;
    }
    public void setIcon(int icon) {
        this.icon = icon;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
}
