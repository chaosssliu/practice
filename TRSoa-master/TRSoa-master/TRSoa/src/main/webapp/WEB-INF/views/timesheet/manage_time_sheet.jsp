<%@include file="/WEB-INF/views/includes/header.jsp" %><%@include file="/WEB-INF/views/includes/navi.jsp" %><div class="panel panel-default">    <div class="panel-body">        <div class="row">            <div class="col-md-1">                <label for="project_select">Project:</label>            </div>            <div class="col-md-4">                <select id="project_select" class="form-control">                    <option></option>                    <c:forEach items="${projList}" var="proj" varStatus="status">                        <option value="${status.index}">${proj.name}</option>                    </c:forEach>                </select>            </div>        </div>    </div></div><%@include file="/WEB-INF/views/includes/footer.jsp" %>