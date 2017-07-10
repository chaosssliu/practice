#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
Submit History:
<c:forEach items="${symbol_dollar}{histList}" var="hist" varStatus="status">
    <div>
        ${symbol_dollar}{hist.status.value} on ${symbol_dollar}{hist.statusDate} - submitted by ${symbol_dollar}{hist.submitter.userDetails.firstName} - reviewer is ${symbol_dollar}{hist.approver.userDetails.firstName}
    </div>
</c:forEach>