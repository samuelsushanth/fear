
<form class="text-center">

    <input type="text" ng-model="vm.examname" title="asd" required>
    <button type="button" ng-click="vm.newExam()">Create</button>
</form><br />
<div class="container" class="table-responsive">
<table class="table table-bordered" >
    <thead>
    <tr class="info">
        <th style="text-align: center"> Exam Name</th>
        <th> </th>
    </tr>
    </thead>
    <tbody>
    <tr ng-repeat="exams in vm.exams" bgcolor="#d3d3d3">
    <td style="text-align: center"> {{exams}}</td>
    <td style="text-align: center"> <a class="btn btn-xs btn-default" href="#/xam">+Question</a></td>

    <tr ng-repeat="exams in vm.exams">
    <td> {{exams}}</td>
    <td> <a class="btn btn-xs btn-default" href="#">+Question</a></td>
    </tr>
    </tbody>
</table>
</div>
