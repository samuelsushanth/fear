<div class="total_form" style="background-color:white;">
            <div>
                <form>
                <div class="form-group">
                  <div>
                    <label for="question">Enter the Exam title:</label>
                    <textarea class="form-control" rows="1" id="exam-title" ng-model="vm.exam"></textarea>
                    </div>
                </div>


                <div style="text-align: right">
                    <button type="submit" ng-click="vm.createExam()">Create</button>

                </div>
            </form>



            {{vm}}
        </div>
</div>