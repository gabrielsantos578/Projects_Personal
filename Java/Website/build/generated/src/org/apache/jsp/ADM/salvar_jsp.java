package org.apache.jsp.ADM;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.text.Normalizer;

public final class salvar_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=ISO-8859-1");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\n");
      out.write("        <script src=\"https://code.jquery.com/jquery-3.2.1.slim.min.js\"></script>\n");
      out.write("        <script src=\"https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.15/jquery.mask.min.js\"></script>\n");
      out.write("        <title>TCC E-commerce</title>   \n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        \n");
      out.write("        <div><center><font size=\"5\">Dados do Produto</font></center></div>\n");
      out.write("        <hr>\n");
      out.write("        <a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/index.html\">Página Inicial</a>\n");
      out.write("        <a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/ListarProduto\">Listar Produtos</a>\n");
      out.write("        <a href=\"produto/consultar.jsp\">Consultar Produto</a>\n");
      out.write("        <br /><br />\n");
      out.write("        \n");
      out.write("        <form name=\"salvarproduto\" action=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/SalvarProduto\" method=\"POST\">\n");
      out.write("            \n");
      out.write("            <table border=\"0\">\n");
      out.write("                \n");
      out.write("                <tbody>\n");
      out.write("                    <tr>\n");
      out.write("                        <td>Cod. Produto</td>\n");
      out.write("                        <td><input type=\"text\" name=\"codigo\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${produto.codigoProduto}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" size=\"70\" readonly=\"true\"/></td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <td>Nome</td>\n");
      out.write("                        <td><input type=\"text\" name=\"nome\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${produto.nomeProduto}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" size=\"70\" required=\"true\"/></td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <td>Preço</td>\n");
      out.write("                        <td><input type=\"text\" name=\"preco\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${produto.precoProduto}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" size=\"70\" required=\"true\" class=\"form-control\"/></td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <td>Quantidade Estoque</td>\n");
      out.write("                        <td><input type=\"text\" name=\"quantidade\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${produto.quantidadeEstoque}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" size=\"70\" required=\"true\" class=\"form-control\"/></td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <td>Descricao</td>\n");
      out.write("                        <td><input type=\"text\" name=\"descricao\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${produto.descricaoProduto}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" size=\"70\" required=\"true\"/></td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <td>Data Fabricação</td>\n");
      out.write("                        <td><input type=\"text\" name=\"data\" size=\"70\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${produto.dataFabricacao}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" required=\"true\" maxlength=\"8\" class=\"form-control\" onkeypress=\"$(this).mask('00/00/0000')\" onkeypress=\"return onlynumber();\"/></td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <td>Lote</td>\n");
      out.write("                        <td><input type=\"text\" name=\"lote\" size=\"70\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${produto.loteProduto}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" required=\"true\" maxlength=\"12\"/></td>\n");
      out.write("                    </tr>\n");
      out.write("                </tbody>\n");
      out.write("                \n");
      out.write("            </table>\n");
      out.write("                    \n");
      out.write("            <input type=\"submit\" value=\"Enviar\" name=\"enviar\" />\n");
      out.write("            \n");
      out.write("        </form>\n");
      out.write("                    \n");
      out.write("        <h2>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${response}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</h2>\n");
      out.write("        \n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
