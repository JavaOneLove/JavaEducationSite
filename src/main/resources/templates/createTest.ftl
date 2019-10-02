<#import "macro/common.ftl" as c>

<@c.page>
<style>
    .Qwest {
    display: block;
        margin: 10px 0px;
    }
    </style>
<script>
    i = 0;
    function AddElement() {
            i++;
            var div = document.createElement("output");
            div.className = "Qwest";
            div.innerHTML = "Вопрос №" + i;
            div.setAttribute('id','t' + i);
            document.forms.namedItem("form1").appendChild(div);
            var element = document.createElement('input');
            element.setAttribute('id', 'q' + i);
            element.setAttribute('type', 'text');
            element.setAttribute('name', 'question[]');
            element.setAttribute('placeholder', 'Вопрос');
            element.className = "Qwest";
            document.forms.namedItem("form1").appendChild(element);
            var element1 = document.createElement('input');
            element1.setAttribute('type', 'text');
            element1.setAttribute('name', 'answer[]');
            element1.setAttribute('placeholder', 'Ответ');
            element1.setAttribute('id','a' + i);
            element1.className = "Qwest";
            document.forms.namedItem("form1").appendChild(element1);
            var Count = document.getElementById("Count");
            Count.setAttribute('value', i);
    }
    function DeleteElement(){
        var deleteT =  document.getElementById('t' + i);
        deleteT.remove();
        var deleteQ =  document.getElementById('q' + i);
        deleteQ.remove();
        var deleteA =  document.getElementById('a' + i);
        deleteA.remove();
        i--;
    }
</script>
<h4>${course}</h4>
  <form name="form1" method="post" enctype="multipart/form-data">
      <p><input type="text" name="title" placeholder="Название теста"/></p>
      <input type="button" onclick="AddElement();" value="Добавить вопрос">
      <input type="button" onclick="DeleteElement();" value="Удалить вопрос">
        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
      <input type="hidden" id="Count" name="Count" value="0"/>
      <button name="AddButton" type="submit">Добавить</button>
    </form>
</@c.page>