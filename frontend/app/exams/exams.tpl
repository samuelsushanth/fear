<html>
<table class="table">
    <thead>
    <tr>
        <th> Exam Name</th>
        <th> </th>
    </tr>
    </thead>
    <tbody>
    <tr ng-repeat=""exams in vm.exams">
    <td> {{exam.text}}</td>
    <td> <a class="btn btn-xs btn-default" href="#/exam/{{exam.id}}">+a</a></td>
    </tr>
    </tbody>
</table>
</html>