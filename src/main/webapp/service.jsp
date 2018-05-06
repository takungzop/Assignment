<%@page import = "java.io.*,java.util.Iterator,org.json.simple.JSONArray,org.json.simple.JSONObject,org.json.simple.parser.JSONParser,org.json.simple.parser.ParseException"%>
<!DOCTYPE html>
<html>
    <head>
         <title>Start Page</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        </head>
    <body>


        <table border=1 align="center">
        
	<thead>
	<tr>
                <th>Phone number</th>
                <th>Service Charge</th>
        </tr>
	</thead>
            <tbody align="center">
	
        <% JSONParser parser = new JSONParser();

        JSONArray a = (JSONArray) parser.parse(new FileReader("C:\\Users\\Garu\\Documents\\NetBeansProjects\\Final\\src\\main\\webapp\\ServiceCharge.json"));

        for (Object o : a)
        {
                out.println("<tr>");
          JSONObject service = (JSONObject) o;

          String phone = (String) service.get("Phone number");
          out.println("<td>"+phone+"</td>");
          double charge = (double) service.get("Service Charge");    
          out.println("<td>"+charge+"</td>");
          
                out.println("</tr>");
        }
           
            %>
              	</tbody>
        </table>
                
    </body>
    
</html>




