package lab.actions;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import lab.classes.JDBCConnection;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.util.LabelValueBean;

	public class SelectGos extends Action{
		public ActionForward execute(ActionMapping mapping, ActionForm form,
			    HttpServletRequest request, HttpServletResponse response)
			    throws SQLException, Exception {
			JDBCConnection jdbcConnection = new JDBCConnection();
			ActionErrors errors = new ActionErrors();
			ActionForward forward = new ActionForward();
			
			Connection connec = null;
			PreparedStatement pstmt_gos = null;
			ResultSet rs_gos = null;
			
			HttpSession session = request.getSession(false);
			session = request.getSession(true);
			try{
			jdbcConnection.setDSConnection("java:comp/env/DataSourceRef");
			connec = jdbcConnection.getConnection();
			
			//=============SelectGos==========
			String query_gos = "SELECT A.KODGOS, A.NAZVG FROM DB2ADMIN.GOS A " +
			" WHERE A.DATAN<=CURRENT_DATE AND A.DATAK>=CURRENT_DATE ";
	    	query_gos += " ORDER BY A.KODGOS ";
	    	pstmt_gos = connec.prepareStatement(query_gos);
	    	rs_gos = pstmt_gos.executeQuery();
	    	ArrayList goss = new ArrayList();
	    	 while (rs_gos.next()) {
	    		 goss.add(new LabelValueBean(rs_gos.getString(1).trim() + " "
	    					+ rs_gos.getString(2).trim(), rs_gos.getString(1).trim()
	    		 + "--" + rs_gos.getString(2).trim()));
	    	 }

	    	 rs_gos.close();
	    		pstmt_gos.close();
	    	//========session============
	    		session.setAttribute("attrGoss", goss);
	    		
	  	}
		catch (SQLException e) {

			// Report the error using the appropriate name and ID.
			errors.add("errorDB2", new ActionError("error.errorDB2", e
					.getMessage()));
			// throw e;

}
		catch (Exception e) {
			
		    // Report the error using the appropriate name and ID.
			if (errors.isEmpty())
				errors.add("Exception", new ActionError("error.Exception", e
						.getMessage()));
		} 
		finally {
			try {
				if (rs_gos != null) {
					rs_gos.close();
				}
				if (pstmt_gos != null) {
					pstmt_gos.close();
				}
					
			if (jdbcConnection.getConnection()!=null)
				jdbcConnection.releaseConnection();
			}
		catch (SQLException e1) {
			if (rs_gos != null) {
				rs_gos.close();
			}
			if (pstmt_gos != null) {
				pstmt_gos.close();
			}
			throw e1;
		}
	}
		if (!errors.isEmpty()) {
		    saveErrors(request, errors);
		    forward = mapping.findForward("failure");
		} else {
			    forward = mapping.findForward("success");
		}
		// Finish with
		return (forward);
	    }		
}
