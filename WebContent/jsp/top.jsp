<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, shrink-to-fit=no, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Custom STT - Open Source version</title>

    <!-- Bootstrap Core CSS -->
    <link href="resources/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="resources/css/simple-sidebar.css" rel="stylesheet">
    
    <!--  Datatables -->
	<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.19/css/jquery.dataTables.css">
  
    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    
    <script>
window.onload = function () {

var options = {
	animationEnabled: true,
	theme: "light2",
	title:{
		text: "Forecast vs Baseline"
	},
	axisX:{
		valueFormatString: "DD MMM"
	},
	axisY: {
		title: "Enrolment",
		suffix: "K",
		minimum: 30
	},
	toolTip:{
		shared:true
	},  
	legend:{
		cursor:"pointer",
		verticalAlign: "bottom",
		horizontalAlign: "left",
		dockInsidePlotArea: true,
		itemclick: toogleDataSeries
	},
	data: [{
		type: "line",
		showInLegend: true,
		name: "Forecast",
		markerType: "square",
		xValueFormatString: "DD MMM, YYYY",
		color: "#F08080",
		yValueFormatString: "#,##0K",
		dataPoints: [
			{ x: new Date(2017, 10, 1), y: 63 },
			{ x: new Date(2017, 10, 2), y: 69 },
			{ x: new Date(2017, 10, 3), y: 65 },
			{ x: new Date(2017, 10, 4), y: 70 },
			{ x: new Date(2017, 10, 5), y: 71 },
			{ x: new Date(2017, 10, 6), y: 65 },
			{ x: new Date(2017, 10, 7), y: 73 },
			{ x: new Date(2017, 10, 8), y: 96 },
			{ x: new Date(2017, 10, 9), y: 84 },
			{ x: new Date(2017, 10, 10), y: 85 },
			{ x: new Date(2017, 10, 11), y: 86 },
			{ x: new Date(2017, 10, 12), y: 94 },
			{ x: new Date(2017, 10, 13), y: 97 },
			{ x: new Date(2017, 10, 14), y: 86 },
			{ x: new Date(2017, 10, 15), y: 89 }
		]
	},
	{
		type: "line",
		showInLegend: true,
		name: "Actual",
		lineDashType: "dash",
		yValueFormatString: "#,##0K",
		dataPoints: [
			{ x: new Date(2017, 10, 1), y: 60 },
			{ x: new Date(2017, 10, 2), y: 57 },
			{ x: new Date(2017, 10, 3), y: 51 },
			{ x: new Date(2017, 10, 4), y: 56 },
			{ x: new Date(2017, 10, 5), y: 54 },
			{ x: new Date(2017, 10, 6), y: 55 },
			{ x: new Date(2017, 10, 7), y: 54 },
			{ x: new Date(2017, 10, 8), y: 69 },
			{ x: new Date(2017, 10, 9), y: 65 },
			{ x: new Date(2017, 10, 10), y: 66 },
			{ x: new Date(2017, 10, 11), y: 63 },
			{ x: new Date(2017, 10, 12), y: 67 },
			{ x: new Date(2017, 10, 13), y: 66 },
			{ x: new Date(2017, 10, 14), y: 56 },
			{ x: new Date(2017, 10, 15), y: 64 }
		]
	}]
};

$("#chartContainer").CanvasJSChart(options);

function toogleDataSeries(e){
	if (typeof(e.dataSeries.visible) === "undefined" || e.dataSeries.visible) {
		e.dataSeries.visible = false;
	} else{
		e.dataSeries.visible = true;
	}
	e.chart.render();
}

$("#tableExample").DataTable();

}
</script>

</head>

<body>
<div class="container">
<div id='myCarousel' class='carousel slide'>
	<ol class='carousel-indicators'></ol>
		<div class='carousel-inner'>
			<div class='item active'>
				<img align="center" src='resources/images/banner.jpeg'  >
				<div class='carousel-caption'>Custom STT</div>
			</div>
		</div> <!--end of caroussel inner -->
</div> <!-- end of caroussel -->
    <div id="wrapper">

        <!-- Sidebar -->
        <div id="sidebar-wrapper">
            <ul class="sidebar-nav">
                <li class="sidebar-brand">
                    <a href="#">
                        Admin
                    </a>
                </li>
                <li>
                    <a href="#">New User</a>
                </li>
                <li>
                    <a href="#">Edit User</a>
                </li>
                <li>
                    <a href="#">Manage Group</a>
                </li>
                <li class="sidebar-brand">
                    <a href="#">
                        Study 
                    </a>
                </li>
                <li>
                    <a href="#">Settings</a>
                </li>
                <li>
                    <a href="#">Overview</a>
                </li>
                <li>
                    <a href="#">Reporting</a>
                </li>

				<li class="sidebar-brand">
                    <a href="#">
                        Manufacturing 
                    </a>
                </li>
				<li>
                    <a href="#">Assign Slot</a>
                </li>
				<li class="sidebar-brand">
                    <a href="#">
                        Reporting
                    </a>
                </li>
                <li>
                    <a href="#">Consolidated view</a>
                </li>
				<li class="sidebar-brand">
                    <a href="#">
                        Log out 
                    </a>
                </li>
 
            </ul>
        </div>
        <!-- /#sidebar-wrapper -->

        <!-- Page Content -->
        <div id="page-content-wrapper">
            <div class="container-fluid">
                <div class="row">
 <!--  Insert the content cells here : 1,2 or 3,.. -->
