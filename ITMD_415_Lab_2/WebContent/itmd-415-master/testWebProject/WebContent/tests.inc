<p><code><% out.write("log test."); %></code></p>

<p><code><%=("context path of request: '" + request.getContextPath() + "'")%></code></p>
<p><code><%=("path of file at './': " + new File("./").getAbsolutePath())%></code></p>
<p><code><%=("real context path of application: " + application.getRealPath(application.getContextPath()))%></code></p>