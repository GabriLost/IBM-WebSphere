package lab.forms;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import java.io.UnsupportedEncodingException;
import java.util.Collection;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class LabForm extends ActionForm {

	private Collection goss = null;
	private String gos =null;
	
	public Collection getGoss(){
		return goss;
	}
	public void setGoss(Collection goss) {
		this.goss = goss;
	}
	
	public String getGos() {
		return gos;
	}
	public void setGos(String g) {
		try {
		this.gos = new String(g.getBytes("ISO-8859-1"),"CP1251");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
//---RESET Function---------
public void reset(ActionMapping mapping, HttpServletRequest request){
	HttpSession session=request.getSession();
	if (session.getAttribute("attrGoss")!=null){
		setGoss((Collection)session.getAttribute("attrGoss"));
	}
gos=null;
}
}
