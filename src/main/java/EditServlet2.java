import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/EditServlet2")
public class EditServlet2 extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String sid = request.getParameter("idusuario");

		if (sid != null && !sid.isEmpty()) {
			try {
				int id = Integer.parseInt(sid);

				String nome = request.getParameter("nome");
				String senha = request.getParameter("senha");
				String email = request.getParameter("email");
				String pais = request.getParameter("pais");

				Funcionario e = new Funcionario();
				e.setIdusuario(id);
				e.setNome(nome);
				e.setSenha(senha);
				e.setEmail(email);
				e.setPais(pais);

				int status = FuncionarioDao.update(e);
				if (status > 0) {
					response.sendRedirect("ViewServlet");
				} else {
					out.println("Desculpe! Não foi possível atualizar o registro.");
				}
			} catch (NumberFormatException e) {
				out.println("ID de usuário inválido. Certifique-se de que seja um número válido.");
			}
		} else {
			out.println("ID de usuário não fornecido ou inválido.");
		}

		out.close();
	}

}