package student_info;


import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Student_data {
    JTree tr;
    JFrame f;
    JLabel l;
    JTable tbTE5, tbTE6, tbTE7, tbTE8;
    JPanel tablePanel;

    List<String> names = Arrays.asList("Komal", "John", "Neha", "Alia", "Rahul", "Priya", "Amit", "Sara", "Vijay", "Anjali");
    int rollNumberCounterTE5 = 1001;
    int rollNumberCounterTE6 = 2001;
    int rollNumberCounterTE7 = 3001;
    int rollNumberCounterTE8 = 4001;

    Student_data() {
        f = new JFrame("Student info");
        f.setLayout(new BorderLayout());
        f.setSize(600, 500);
        f.setVisible(true);
        init();
        addcompo();
        event_handling();
    }

    public void init() {
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("class");
        DefaultMutableTreeNode te5 = new DefaultMutableTreeNode("TE5");
        DefaultMutableTreeNode te6 = new DefaultMutableTreeNode("TE6");
        DefaultMutableTreeNode te7 = new DefaultMutableTreeNode("TE7");
        DefaultMutableTreeNode te8 = new DefaultMutableTreeNode("TE8");
        DefaultMutableTreeNode ajp = new DefaultMutableTreeNode("AJP");
        DefaultMutableTreeNode cn = new DefaultMutableTreeNode("CN");
        DefaultMutableTreeNode pm = new DefaultMutableTreeNode("PM");

        DefaultMutableTreeNode ajp2 = new DefaultMutableTreeNode("AJP");
        DefaultMutableTreeNode cn2 = new DefaultMutableTreeNode("CN");
        DefaultMutableTreeNode pm2 = new DefaultMutableTreeNode("PM");

        DefaultMutableTreeNode ajp3 = new DefaultMutableTreeNode("AJP");
        DefaultMutableTreeNode cn3 = new DefaultMutableTreeNode("CN");
        DefaultMutableTreeNode pm3 = new DefaultMutableTreeNode("PM");

        DefaultMutableTreeNode ajp4 = new DefaultMutableTreeNode("AJP");
        DefaultMutableTreeNode cn4 = new DefaultMutableTreeNode("CN");
        DefaultMutableTreeNode pm4 = new DefaultMutableTreeNode("PM");
        te5.add(ajp);
        te5.add(cn);
        te5.add(pm);

        te6.add(ajp3);
        te6.add(cn3);
        te6.add(pm3);

        te7.add(ajp2);
        te7.add(cn2);
        te7.add(pm2);

        te8.add(ajp4);
        te8.add(cn4);
        te8.add(pm4);

        root.add(te5);
        root.add(te6);
        root.add(te7);
        root.add(te8);

        tr = new JTree(root);
        l = new JLabel("Class Marks: ");
    }

    public void event_handling() {
        tr.addTreeSelectionListener(new TreeSelectionListener() {
            public void valueChanged(TreeSelectionEvent e) {
                DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) tr.getLastSelectedPathComponent();
                if (selectedNode != null) {
                    String nodeName = selectedNode.toString();
                    switch (nodeName) {
                        case "TE5":
                            l.setText("Class Marks: TE5");
                            showTable(tbTE5);
                            break;
                        case "TE6":
                            l.setText("Class Marks: TE6");
                            showTable(tbTE6);
                            break;
                        case "TE7":
                            l.setText("Class Marks: TE7");
                            showTable(tbTE7);
                            break;
                        case "TE8":
                            l.setText("Class Marks: TE8");
                            showTable(tbTE8);
                            break;
                        case "AJP":
                        case "CN":
                        case "PM":
                            return;
                        default:
                            l.setText("Class Marks: " + nodeName);
                            hideTables();
                    }
                }
            }
        });
    }

    private void showTable(JTable table) {
        hideTables();
        tablePanel.removeAll();
        tablePanel.add(new JScrollPane(table), BorderLayout.CENTER);
        tablePanel.revalidate();
        tablePanel.repaint();
    }

    private void hideTables() {
        tablePanel.removeAll();
        tablePanel.revalidate();
        tablePanel.repaint();
    }

    public void addcompo() {
        String col[] = {"Roll Number", "Name", "AJP", "CN", "PM"};

        DefaultTableModel modelTE5 = new DefaultTableModel(col, 0);
        DefaultTableModel modelTE6 = new DefaultTableModel(col, 0);
        DefaultTableModel modelTE7 = new DefaultTableModel(col, 0);
        DefaultTableModel modelTE8 = new DefaultTableModel(col, 0);

        addRandomData(modelTE5, 5, "TE5", rollNumberCounterTE5);
        addRandomData(modelTE6, 6, "TE6", rollNumberCounterTE6);
        addRandomData(modelTE7, 7, "TE7", rollNumberCounterTE7);
        addRandomData(modelTE8, 8, "TE8", rollNumberCounterTE8);

        tbTE5 = new JTable(modelTE5);
        tbTE6 = new JTable(modelTE6);
        tbTE7 = new JTable(modelTE7);
        tbTE8 = new JTable(modelTE8);

        tablePanel = new JPanel(new BorderLayout());

        JPanel leftPanel = new JPanel(new BorderLayout());
        leftPanel.add(new JScrollPane(tr), BorderLayout.CENTER);

        JPanel centerPanel = new JPanel(new BorderLayout());
        centerPanel.add(l, BorderLayout.NORTH);
        centerPanel.add(tablePanel, BorderLayout.CENTER);

        f.add(leftPanel, BorderLayout.WEST);
        f.add(centerPanel, BorderLayout.CENTER);
    }

    private void addRandomData(DefaultTableModel model, int count, String className, int rollNumberCounter) {
        Random random = new Random();
        for (int i = 1; i <= count; i++) {
            String name = getRandomName();
            int ajp = random.nextInt(31); 
            int cn = random.nextInt(31);
            int pm = random.nextInt(31);
            model.addRow(new Object[]{rollNumberCounter++, name, ajp, cn, pm});
        }
    }

    private String getRandomName() {
    	
        Random rand = new Random();
        return names.get(rand.nextInt(names.size()));
        
    }

    public static void main(String[] args) {
        new Student_data();
    }
}
