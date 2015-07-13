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
import lab.classes.ShowClass;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.util.LabelValueBean;
import lab.forms.LabForm;

	public class SelectDor extends Action{
		public ActionForward execute(ActionMapping mapping, ActionForm form,
			    HttpServletRequest request, HttpServletResponse response)
			    throws SQLException, Exception {
			LabForm labForm = (LabForm) form;
			JDBCConnection jdbcConnection = new JDBCConnection();
			ActionErrors errors = new ActionErrors();
			ActionForward forward = new ActionForward();
			Connection connec = null;
			PreparedStatement pstmt_dor = null;
			ResultSet rs_dor = null;
			ShowClass sc;
			ArrayList tableRows = new ArrayList();
			HttpSession session = request.getSession(false);
			try{
			jdbcConnection.setDSConnection("java:comp/env/DataSourceRef");
			connec = jdbcConnection.getConnection();
			String gos = labForm.getGos();
			String [] temp = null;
			temp = gos.split("--");
			gos = temp[0];
			
			
			//=============SelectGos==========
			String query_dor = "SELECT A.KODD, A.KODG, A.NAZVD, A.SNAZVD, A.VC, B.VC_NAMES, A.PR_NYAZ, B.VC_VIDSTVC " +
			" FROM DB2ADMIN.DOR A, DB2ADMIN.VC B WHERE "+
			" A.VC=B.VC_KODVC AND A.KODG = ? ";
	    	query_dor += " ORDER BY A.KODD ";
	    	pstmt_dor = connec.prepareStatement(query_dor);
	    	pstmt_dor.setString(1,gos);
	    	rs_dor= pstmt_dor.executeQuery();
	    	
	    	 while (rs_dor.next()) {
	    		 sc = new ShowClass();
	    		 sc.setKodd(rs_dor.getString(1));
	    		 sc.setKodg(rs_dor.getString(2));
	    		 sc.setNazvd(rs_dor.getString(3));
	    		 sc.setSnazvd(rs_dor.getString(4));
	    		 sc.setVc(rs_dor.getString(5));
	    		 sc.setVc_names(rs_dor.getString(6));
	    		 sc.setPr_nyaz(rs_dor.getString(7));
	    		 sc.setVc_vidstvc(rs_dor.getString(8));
	    		 tableRows.add(sc);
	    		 	    	 }
	    	 rs_dor.close();
	    		pstmt_dor.close();
	    	//========session============
	    	
	    		session.setAttribute("tableRows", tableRows);
	    		
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
				if (rs_dor != null) {
					rs_dor.close();
				}
				if (pstmt_dor != null) {
					pstmt_dor.close();
				}
					
			if (jdbcConnection.getConnection()!=null)
				jdbcConnection.releaseConnection();
			}
		catch (SQLException e1) {
			if (rs_dor != null) {
				rs_dor.close();
			}
			if (pstmt_dor != null) {
				pstmt_dor.close();
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
