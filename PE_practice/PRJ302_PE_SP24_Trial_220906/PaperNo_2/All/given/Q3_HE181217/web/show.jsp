<%-- 
    Document   : show
    Created on : Jun 21, 2024, 9:19:02 AM
    Author     : admin
--%>

<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

        <label>List of subjects 
            <select name="subject-name">
                <option selected}>All Subjects</option>
                <c:forEach var="subject" items="${requestScope.allSubjectsWithStudents}">
                    <option>${subject.subjectName}</option>
                </c:forEach>
            </select>
        </label>
        
        <br>
        <br>
        <div>List of Students:</div>
        <table name="All Subjects" class="list-of-students" border="1">
            <thead>
                <tr>
                    <th>Code</th>
                    <th>Name</th>
                    <th>Date of birth</th>
                    <th>Gender</th>
                    <th>Subject</th>
                    <th>Select</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="student" items="${requestScope.allStudents}">
                    <tr>
                        <td name="student-id">${student.studentID}</td>
                        <td name="student-name">${student.studentName}</td>
                        <td name="student-birthdate">${student.birthDate}</td>
                        <c:choose>
                            <c:when test="${student.gender}">
                                <td name="student-gender">Male</td>
                            </c:when>
                            <c:otherwise>
                                <td name="student-gender">Female</td>
                            </c:otherwise>
                        </c:choose>
                        <td name="student-subject">${student.subjectName}</td>
                        <td><a href="#" onclick="show(this)">Select</a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

        <c:forEach var="subject" items="${requestScope.allSubjectsWithStudents}">

            <table name="${subject.subjectName}" class="list-of-students" border="1" style="display: none">
                <thead>
                    <tr>
                        <th>Code</th>
                        <th>Name</th>
                        <th>Date of birth</th>
                        <th>Gender</th>
                        <th>Subject</th>
                        <th>Select</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="student" items="${subject.students}">
                        <tr>
                            <td name="student-id">${student.studentID}</td>
                            <td name="student-name">${student.studentName}</td>
                            <td name="student-birthdate">${student.birthDate}</td>
                            <c:choose>
                                <c:when test="${student.gender}">
                                    <td name="student-gender">Male</td>
                                </c:when>
                                <c:otherwise>
                                    <td name="student-gender">Female</td>
                                </c:otherwise>
                            </c:choose>
                            <td name="student-subject">${student.subjectName}</td>
                            <td><a href="#" onclick="show(this)">Select</a></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>

        </c:forEach>

        <br>
        <div> Detail information: </div>
        <table border="0">
            <thead>
                <tr>
                    <th></th>
                    <th></th>
                    <th></th>
                    <th></th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>Code: </td>
                    <td><input type="text" name="selected-student-id" value="" /></td>
                    <td>Name: </td>
                    <td><input type="text" name="selected-student-name" value="" /></td>
                </tr>
                <tr>
                    <td>Date of birth: </td>
                    <td><input type="text" name="selected-student-birthdate" value="" /></td>
                    <td>Gender: </td>
                    <td><input type="radio" name="selected-student-gender" value="Male" /> Male
                        <input type="radio" name="selected-student-gender" value="Female" /> Female</td>
                </tr>
                <tr>
                    <td>Subject: </td>
                    <td><input type="text" name="selected-student-subject" value="" /></td>
                </tr>
            </tbody>
        </table>


    </body>
    <script>
        
        function submitForm() {
            document.getElementById("subjectForm").submit();
        }
        
        var subjectName = document.getElementsByName("subject-name")[0];
        subjectName.addEventListener("change", function () {
            var subject = subjectName.value;
            var tables = document.getElementsByClassName("list-of-students");
            for (var i = 0; i < tables.length; i++) {
                var table = tables[i];
                if (table.getAttribute("name") === subject) {
                    table.style.display = "table";
                } else {
                    table.style.display = "none";
                }
            }
        });

        function show(element) {
            var studentIDColumn = element.parentElement.parentElement.children[0];
            var studentID = studentIDColumn.innerText;
            var code = document.querySelector('input[name="selected-student-id"]');
            if (code) {
                code.value = studentID;
            }

            var studentNameColumn = element.parentElement.parentElement.children[1];
            var studentName = studentNameColumn.innerText;
            var code = document.querySelector('input[name="selected-student-name"]');
            if (code) {
                code.value = studentName;
            }

            var studentBirthDateColumn = element.parentElement.parentElement.children[2];
            var studentBirthDate = studentBirthDateColumn.innerText;
            var code = document.querySelector('input[name="selected-student-birthdate"]');
            if (code) {
                code.value = studentBirthDate;
            }

            var studentGenderColumn = element.parentElement.parentElement.children[3];
            var studentGender = studentGenderColumn.innerText;
            var genderRadioMale = document.querySelector('input[name="selected-student-gender"][value="Male"]');
            var genderRadioFemale = document.querySelector('input[name="selected-student-gender"][value="Female"]');
            if (studentGender === "Male") {
                genderRadioMale.checked = true;
            } else {
                genderRadioFemale.checked = true;
            }

            var studentSubjectColumn = element.parentElement.parentElement.children[4];
            var studentSubject = studentSubjectColumn.innerText;
            var code = document.querySelector('input[name="selected-student-subject"]');
            if (code) {
                code.value = studentSubject;
            }
        }

    </script>
</html>
