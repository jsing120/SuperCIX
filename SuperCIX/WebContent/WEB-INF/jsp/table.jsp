<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<link rel='stylesheet' href='//cdn.datatables.net/plug-ins/f2c75b7247b/integration/bootstrap/3/dataTables.bootstrap.css'/>

<c:if test="${not empty message}">

	<table id="tagTable" class="table table-striped table-bordered"
		cellspacing="0" width="100%">
		<thead>
			<tr>
				<th>Element Tag</th>
				<th>Can be Converted?</th>
			</tr>
		</thead>
		<tbody id="ajaxbody">
			<c:forEach var="listValue" items="${message}">
				<tr>
					<td>${listValue.tagName}
					</td>
					<td><c:choose>
							<c:when test="${listValue.canBeConverted}">
								<i class="fa fa-check-square"
									style="color: green; font-size: 24px;"></i>
							</c:when>
							<c:otherwise>
								<i class="fa fa-exclamation-triangle"
									style="color: red; font-size: 24px;"></i>
							</c:otherwise>
						</c:choose>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>


</c:if>
 <script src="http://malsup.github.com/jquery.form.js"></script>
		<script type="text/javascript" src="//cdn.datatables.net/1.10.5/js/jquery.dataTables.min.js"></script>
		
		<script
		src="//cdn.datatables.net/plug-ins/f2c75b7247b/integration/bootstrap/3/dataTables.bootstrap.js"></script>
		<script type="text/javascript">
			$(document).ready(function(){
			    $('#tagTable').DataTable({ "deferRender": true});
			});
