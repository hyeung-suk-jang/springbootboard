<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>글쓰기 페이지</title>
</head>
<body>
여기는 글쓰기 페이지 입니다.
<form name="f1" id="f1" action="/board/editok" method="post" accept-charset="utf-8">
    <input type="hidden" name="boardidx" id="boardidx" value="${board.boardidx}"/>
    글쓴이<input type="text" name="writer" id="writer" value="${board.writer}"><br>
    제목 <input type="text" name="title" id="title" value="${board.title}"><br>
    본문<textarea name="contents" cols="50" rows="10" id="contents">${board.contents}</textarea>
    <br>
    <input type="submit" value="전송" id="btnsubmit">
</form>
<script
        src="https://code.jquery.com/jquery-3.4.1.js"
        integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU="
        crossorigin="anonymous"></script>
<script>
    $(function(){
        $("#btnsubmit").click(function(e){
            e.preventDefault();
            if(!$("input[name='writer']").val()){
                alert("글쓴이를 입력해주세요");
                $("#writer").focus();
                return false;
            }
            if(!$("input[name='title']").val()){
                alert("제목을 입력해주세요");
                $("#title").focus();
                return false;
            }
            if(!$("#contents").val()){
                alert("본문을 입력해주세요");
                $("#contents").focus();
                return false;
            }

            f1.submit();
        })

    });
</script>
</body>
</html>
