import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.LayoutManager;

/**
 * Class which creates all the components of the GUI as well as specifies their locations in the container.
 * 
 * @author Dulia
 *
 */
class RationalGUILayout implements LayoutManager {

    public RationalGUILayout() {
    }

    public void addLayoutComponent(String name, Component comp) {
    }

    public void removeLayoutComponent(Component comp) {
    }

    public Dimension preferredLayoutSize(Container parent) {
        Dimension dim = new Dimension(0, 0);

        Insets insets = parent.getInsets();
        dim.width = 320 + insets.left + insets.right;
        dim.height = 240 + insets.top + insets.bottom;

        return dim;
    }

    public Dimension minimumLayoutSize(Container parent) {
        Dimension dim = new Dimension(0, 0);
        return dim;
    }

    public void layoutContainer(Container parent) {
        Insets insets = parent.getInsets();

        Component c;
        c = parent.getComponent(0);
        if (c.isVisible()) {c.setBounds(insets.left+104,insets.top+8,168,24);}
        c = parent.getComponent(1);
        if (c.isVisible()) {c.setBounds(insets.left+8,insets.top+56,88,24);}
        c = parent.getComponent(2);
        if (c.isVisible()) {c.setBounds(insets.left+8,insets.top+96,88,24);}
        c = parent.getComponent(3);
        if (c.isVisible()) {c.setBounds(insets.left+8,insets.top+144,88,24);}
        c = parent.getComponent(4);
        if (c.isVisible()) {c.setBounds(insets.left+112,insets.top+56,50,24);}
        c = parent.getComponent(5);
        if (c.isVisible()) {c.setBounds(insets.left+112,insets.top+96,50,24);}
        c = parent.getComponent(6);
        if (c.isVisible()) {c.setBounds(insets.left+112,insets.top+144,112,24);}
        c = parent.getComponent(7);
        if (c.isVisible()) {c.setBounds(insets.left+248,insets.top+48,48,24);}
        c = parent.getComponent(8);
        if (c.isVisible()) {c.setBounds(insets.left+248,insets.top+80,48,24);}
        c = parent.getComponent(9);
        if (c.isVisible()) {c.setBounds(insets.left+50,insets.top+200,256,24);}
        c = parent.getComponent(10);
        if (c.isVisible()) {c.setBounds(insets.left+248,insets.top+112,48,24);}
        c = parent.getComponent(11);
        if (c.isVisible()) {c.setBounds(insets.left+248,insets.top+144,48,24);}
        c = parent.getComponent(12);
        if (c.isVisible()) {c.setBounds(insets.left+152,insets.top+56,32,24);}
        c = parent.getComponent(13);
        if (c.isVisible()) {c.setBounds(insets.left+152,insets.top+96,32,24);}
        c = parent.getComponent(14);
        if (c.isVisible()) {c.setBounds(insets.left+174,insets.top+56,50,24);}
        c = parent.getComponent(15);
        if (c.isVisible()) {c.setBounds(insets.left+174,insets.top+96,50,24);}
    }
}
