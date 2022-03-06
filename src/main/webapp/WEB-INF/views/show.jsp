<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html lang="en">

<head>

  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>Tomasz Plonski - Workshop 3</title>

  <!-- Custom fonts for this template-->
  <link href="../../static/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
  <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">

  <!-- Custom styles for this template-->
  <link href="../../static/css/sb-admin-2.min.css" rel="stylesheet">

</head>

<body id="page-top">

  <!-- Page Wrapper -->
  <div id="wrapper">


    <!-- Sidebar -->
    <jsp:include page="fragments/sidebar.jsp"/>
    <!-- End of Sidebar -->

    <!-- Content Wrapper -->
    <div id="content-wrapper" class="d-flex flex-column">

      <!-- Main Content -->
      <div id="content">

        <!-- Topbar -->
        <nav class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">

          </ul>

        </nav>
        <!-- End of Topbar -->

        <!-- Begin Page Content -->
        <div class="container-fluid">

          <!-- Page Heading -->
          <div class="d-sm-flex align-items-center justify-content-between mb-4">
            <h1 class="h3 mb-0 text-gray-800">UsersCRUD</h1>
            <a href="/list" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm"><i class="text-white-50"></i>User List</a>
          </div>

          <!-- DataTales Example -->
          <div class="card shadow mb-4">
            <div class="card-header d-sm-table-row py-3">
              <h6 class="m-0 font-weight-bold text-primary">User details</h6>
            </div>
            <div class="card-body">
              <div class="table-responsive">
                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                  <thead>
                  <tr>
                    <td>Id</td>
                    <td>${user.id}</td>
                  </tr>
                  <tr>
                      <td>User Name</td>
                      <td>${user.userName}</td>
                  </tr>
                  <tr>
                      <td>email</td>
                      <td>${user.email}</td>
                  </tr>
                  </thead>
                </table>
              </div>
            </div>
          </div>

        </div>
        <!-- /.container-fluid -->

      </div>
      <!-- End of Main Content -->

      <!-- Footer -->
      <jsp:include page="fragments/footer.jsp"/>
      <!-- End of Footer -->

    </div>
    <!-- End of Content Wrapper -->

  </div>
  <!-- End of Page Wrapper -->


  <!-- Bootstrap core JavaScript-->
  <script src="../../static/vendor/jquery/jquery.min.js"></script>
  <script src="../../static/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

  <!-- Core plugin JavaScript-->
  <script src="../../static/vendor/jquery-easing/jquery.easing.min.js"></script>

  <!-- Custom scripts for all pages-->
  <script src="../../static/js/sb-admin-2.min.js"></script>

  <!-- Page level plugins -->
  <script src="../../static/vendor/chart.js/Chart.min.js"></script>

  <!-- Page level custom scripts -->
  <script src="../../static/js/demo/chart-area-demo.js"></script>
  <script src="../../static/js/demo/chart-pie-demo.js"></script>

</body>

</html>
