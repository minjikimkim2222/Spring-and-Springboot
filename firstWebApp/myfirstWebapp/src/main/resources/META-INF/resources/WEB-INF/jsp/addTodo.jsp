<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>

<div class="container">
    <h1>Enter Todo Details</h1>
    <form:form method="post" modelAttribute="todo">
        <fieldset class="mb-3">
            <form:label path="description">Description : </form:label>
            <form:input type="text" path="description" required="required" />
            <form:errors path="description" cssClass="text-warning" /><br>
        </fieldset>

        <fieldset class="mb-3">
            <form:label path="deadline">Deadline : </form:label>
            <form:input type="text" path="deadline" required="required" />
            <form:errors path="deadline" cssClass="text-warning" /><br>
        </fieldset>

        <form:input type="hidden" path="id" /><br>
        <form:input type="hidden" path="done" /><br>
        <input type="submit" class="btn btn-success" />
    </form:form>
</div>
<%@ include file="common/footer.jspf" %>
<script type="text/javascript">
    $('#deadline').datepicker({
        format: 'yyyy-mm-dd'
    });
</script>
