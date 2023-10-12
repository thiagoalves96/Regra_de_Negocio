import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/EditServlet")
public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<h1>Editar Funcionário</h1>");
		String sid = request.getParameter("idusuario");
		int id = Integer.parseInt(sid);

		Funcionario e = FuncionarioDao.getFuncionarioByidusuario(id);
		out.print("<!DOCTYPE html>");
		out.print("<html lang='pt-br'>");
		out.print("<head>");
		out.print("<meta charset='UTF-8'>");
		out.print("<title>Editar Funcionário</title>");
		out.print("</head>");
		out.print("<body>");
		out.print("<form action='EditServlet2' method='post'>");
		out.print("<table>");
		out.print(
				"<tr><td></td><td><input type='hidden' name='idusuario' value='" + e.getIdusuario() + "'/></td></tr>");
		out.print("<tr><td>Nome:</td><td><input type='text' name='nome' value='" + e.getNome() + "'/></td></tr>");
		out.print(
				"<tr><td>Senha:</td><td><input type='password' name='senha' value='" + e.getSenha() + "'/> </td></tr>");
		out.print("<tr><td>E-mail:</td><td><input type='email' name='email' value='" + e.getEmail() + "'/></td></tr>");
		out.print("<tr><td>País:</td><td>");
		out.print("<select name='pais' style='width:150px'>");
		out.print("<option>Brasil</option>");
		out.print("<option>Argentina</option>");
		out.print("<option>Chile</option>");
		out.print("<option>Outros</option>");
		out.print("</select>");
		out.print("</td></tr>");
		out.print("<tr><td colspan='2'><input type='submit' value='Editar e Salvar'/></td></tr>");
		out.print("</table>");
		out.print("</form>");
		out.print("</body>");
		out.print("</html>");
		out.close();
	}

}
