import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AddMenu extends JFrame implements ActionListener {
	private JPanel Mainp;
	private JTextField tfmenu, tfprice;
	private JLabel lblmenu, lblprice;
	private JButton ok, cancel;
	public AddMenu() {
		setTitle("메뉴 추가");
		setSize(400, 300);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		Mainp = new JPanel();
		Mainp.setBackground(Color.lightGray);
		add(Mainp);
		Mainp.setLayout(null);
		lblmenu = new JLabel("메뉴 : ");
		lblprice = new JLabel("가격 : ");
		lblmenu.setBounds(10, 10, 100, 100);
		lblprice.setBounds(10, 50, 100, 100);

		tfmenu = new JTextField(10);
		tfmenu.setBounds(65, 45, 120, 30);
		tfprice = new JTextField(20);
		tfprice.setBounds(65, 90, 120, 30);
		ok = new RoundedButton("확인");
		cancel = new RoundedButton("취소");

		ok.setBounds(100, 190, 90, 30);
		cancel.setBounds(220, 190, 90, 30);
		Mainp.add(lblmenu);
		Mainp.add(lblprice);
		Mainp.add(tfmenu);
		Mainp.add(tfprice);
		Mainp.add(ok);
		Mainp.add(cancel);
		setVisible(true);
		ok.addActionListener(this);
		cancel.addActionListener(this);
	}

	public static void main(String[] args) {
		AddMenu mf = new AddMenu(); // ���ο� ��ü�� ���� �ҷ����°�, ���ο��� ���� �������� �ҷ��� �ܼ� ���� ����
	}

	private void insertMemnu() {
		DBMenu dm = getViewData();
		DBConnect dc = new DBConnect();
		boolean ok = dc.insertMenu(dm);
	}

	public DBMenu getViewData() {
		DBMenu dm = new DBMenu();
		DBConnect dc = new DBConnect();
		DBMenu v = dc.findmenunum();
		String menunum = v.getMenuNum();
		String menuname = tfmenu.getText();
		String menuprice = tfprice.getText();
		String menuimage = null;
		dm.setMenuNum(menunum);
		dm.setMenuName(menuname);
		dm.setMenuPrice(menuprice);
		dm.setMenuImage(menuimage);
		return dm;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object obj = e.getSource();
		if (obj == ok) {
			insertMemnu();
			dispose();

		} else if (obj == cancel) {
			dispose();

		}
	}

}
