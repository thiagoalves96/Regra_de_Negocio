import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ViewServlet")
public class ViewServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		out.println("<a href='index.html'> Adicionar um novo Funcionário </a>");
		out.println("<h1> Lista de Funcionarios </h1>");

		List<Funcionario> list = FuncionarioDao.getAllFuncionario();

		out.print("<table border='1' width='100%'");
		out.print(
				"<tr><th>Id</th><th>Nome</th><th>Senha</th><th>Email</th><th>Pais</th><th>Edit</th><th>Delete</th></tr>");
		for (Funcionario e : list) {
			out.print(
					"<tr><td>" + e.getIdusuario() + "</td><td>" + e.getNome() + "</td><td>" + e.getSenha() + "</td><td>"
							+ e.getEmail() + "</td><td>" + e.getPais() + "</td><td><a href='EditServlet?idusuario="
							+ e.getIdusuario() + "'>edit</a></td><td><a href='DeleteServlet?idusuario="
							+ e.getIdusuario() + "'>delete</a></td></tr>");
		}
		out.print("</table>");

		out.close();
	}
}