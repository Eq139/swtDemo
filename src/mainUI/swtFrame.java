package mainUI;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import swing2swt.layout.FlowLayout;
import org.eclipse.swt.widgets.Label;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.custom.StackLayout;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormAttachment;
import swing2swt.layout.BorderLayout;
import org.eclipse.swt.graphics.Point;
import org.eclipse.wb.swt.SWTResourceManager;

import com.linan.truck.pojo.CommConfig;

import memcached.MemcacheManager;

import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;

public class swtFrame {

	protected Shell shell;
	private Button btnConfirm;
	private Text text;
	private Label lblAddr;
	private Text text_2;
	private StringBuilder sb = new StringBuilder();

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			swtFrame window = new swtFrame();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	private void setBuilder(Map<Integer, CommConfig> map) {
		text_2.setText("");
		sb.delete(0, sb.length());
		Integer intNum = Integer.valueOf(text.getText());
		CommConfig config = map.get(intNum);
		if (config ==null) {
			sb.append("id不存在");
			sb.append("所有的id:");
			sb.append("\n");
			for (Integer i : map.keySet()) {
				sb.append(i+"\n");
			}
		}else{
			sb.append("类型:"+config.getConfigNameZh()+"\n数值:"+config.getConfigValue()+"\n字符值:"+config.getConfigValueStr()+"\n启用状态:"+config.getIsEnable()+"-"+("1".equals(config.getIsEnable())?"启用":"不启用"));
		}
	}
	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setMinimumSize(new Point(300, 155));
		shell.setSize(450, 300);
		shell.setText("SWT Application");
		shell.setLayout(null);
		
		btnConfirm = new Button(shell, SWT.NONE);
		
		btnConfirm.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				
				Map<Integer, CommConfig> map = MemcacheManager.get(MemcacheManager.COMMON_CONFIG_MAP_KEY);
				if(null==text.getText() ||"".equals(text.getText())){
					System.out.println("false");
					
				}else{
					setBuilder(map);
				}
				text_2.setText(sb.toString());
			}

			
		});
		btnConfirm.setBounds(318, 206, 80, 25);
		btnConfirm.setText("Click here");
		
		text = new Text(shell, SWT.BORDER);
		text.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				Map<Integer, CommConfig> map = MemcacheManager.get(MemcacheManager.COMMON_CONFIG_MAP_KEY);
				if(e.keyCode==13){
					setBuilder(map);
				}
				text_2.setText(sb.toString());
			}
		});
		text.setBounds(137, 21, 261, 21);
		lblAddr = new Label(shell, SWT.NONE);
		lblAddr.setBounds(71, 24, 41, 15);
		lblAddr.setText("id");
		
		text_2 = new Text(shell, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL | SWT.CANCEL | SWT.MULTI);
		text_2.setEditable(false);
		text_2.setBounds(71, 48, 327, 152);
		
		
	}
}
