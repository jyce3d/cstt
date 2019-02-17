
<%@include file="top.jsp" %>
                    <div class="col-lg-12">
                        <h1>Custom STT</h1>
                        <p>Study Tracking Tool is intented to track and enrollment for studies according to constraints such as manufacturing bottleneck or others</p>
                        <p>Based on Datatables, Canvas and SideBar frameworks. Make sure to keep all page content within the <code>#page-content-wrapper</code>.</p>
                        <table id="tableExample" class="display">
                         	<thead>
        					<tr>
            				<th>Name</th>
            				<th>Code</th>
            				<th>Description</th>
            				<th>Start Date</th>
            				<th>Total Enrolled</th>
        					</tr>
    						</thead>
    						<tbody>
        					<tr>
            				<td>ALLONAB</td>
            				<td>ALLONAB</td>
            				<td>Phase I dose escalation</td>
            				<td>18MAY2018</td>
            				<td>81</td>            				
        					</tr>
        					<tr>
            				<td>LYNX</td>
            				<td>LYNX</td>
            				<td>Phase II randomized dose escalation</td>
            				<td>18MAY2018</td>
            				<td>126</td>
        					</tr>
    						</tbody>
    					</table>
                        <a href="#menu-toggle" class="btn btn-default" id="menu-toggle">Toggle Menu</a>
                    </div>
					<div class="col-lg-12">
					
						<div id="chartContainer" style="height: 370px; width: 100%;"></div>
				<!-- 		<p>https://canvasjs.com/jquery-charts/line-chart/</p> -->
						
					</div>
					<div class="col-lg-12">
						<div id="consolidateContainer" style="height:370px; width: 100%"></div>
					</div>
<%@include file="bottom.jsp" %>
					