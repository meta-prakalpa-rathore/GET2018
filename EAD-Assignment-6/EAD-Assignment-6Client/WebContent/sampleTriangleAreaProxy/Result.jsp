<%@page contentType="text/html;charset=UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<HTML>
<HEAD>
<TITLE>Result</TITLE>
</HEAD>
<BODY>
<H1>Result</H1>

<jsp:useBean id="sampleTriangleAreaProxyid" scope="session" class="soap.TriangleAreaProxy" />
<%
if (request.getParameter("endpoint") != null && request.getParameter("endpoint").length() > 0)
sampleTriangleAreaProxyid.setEndpoint(request.getParameter("endpoint"));
%>

<%
String method = request.getParameter("method");
int methodID = 0;
if (method == null) methodID = -1;

if(methodID != -1) methodID = Integer.parseInt(method);
boolean gotMethod = false;

try {
switch (methodID){ 
case 2:
        gotMethod = true;
        java.lang.String getEndpoint2mtemp = sampleTriangleAreaProxyid.getEndpoint();
if(getEndpoint2mtemp == null){
%>
<%=getEndpoint2mtemp %>
<%
}else{
        String tempResultreturnp3 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(getEndpoint2mtemp));
        %>
        <%= tempResultreturnp3 %>
        <%
}
break;
case 5:
        gotMethod = true;
        String endpoint_0id=  request.getParameter("endpoint8");
            java.lang.String endpoint_0idTemp = null;
        if(!endpoint_0id.equals("")){
         endpoint_0idTemp  = endpoint_0id;
        }
        sampleTriangleAreaProxyid.setEndpoint(endpoint_0idTemp);
break;
case 10:
        gotMethod = true;
        soap.TriangleArea getTriangleArea10mtemp = sampleTriangleAreaProxyid.getTriangleArea();
if(getTriangleArea10mtemp == null){
%>
<%=getTriangleArea10mtemp %>
<%
}else{
        if(getTriangleArea10mtemp!= null){
        String tempreturnp11 = getTriangleArea10mtemp.toString();
        %>
        <%=tempreturnp11%>
        <%
        }}
break;
case 13:
        gotMethod = true;
        String sideA_1id=  request.getParameter("sideA16");
        double sideA_1idTemp  = Double.parseDouble(sideA_1id);
        String sideB_2id=  request.getParameter("sideB18");
        double sideB_2idTemp  = Double.parseDouble(sideB_2id);
        String sideC_3id=  request.getParameter("sideC20");
        double sideC_3idTemp  = Double.parseDouble(sideC_3id);
        double getAreaOfTriangle13mtemp = sampleTriangleAreaProxyid.getAreaOfTriangle(sideA_1idTemp,sideB_2idTemp,sideC_3idTemp);
        String tempResultreturnp14 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(getAreaOfTriangle13mtemp));
        %>
        <%= tempResultreturnp14 %>
        <%
break;
}
} catch (Exception e) { 
%>
Exception: <%= org.eclipse.jst.ws.util.JspUtils.markup(e.toString()) %>
Message: <%= org.eclipse.jst.ws.util.JspUtils.markup(e.getMessage()) %>
<%
return;
}
if(!gotMethod){
%>
result: N/A
<%
}
%>
</BODY>
</HTML>