<!DOCTYPE html>
<html>
<head>
	<title></title>
	<link <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<div class="row">
<div class="col-sm-4">
<h1>Bienvenue</h1>
<h3>Liste des utilisateurs</h3>
<FORM Method="GET" Action="/utilisateurServelet">
<INPUT type=submit value=Afficher la liste>
</FORM>
<br>
<hr>
<table>
    <c:forEach items="${utilisateurs}" var="utilisateur">
        <tr>
            <td>${utilisateur.mail}</td>
            <td>${utilisateur.nom}</td>
            <td>${utilisateur.prenom}</td>
            <td><a href="UserInfo2?mail=${utilisateur.email}">detail</a></td>
        </tr>
    </c:forEach>
</table>

</div>
<div class="col-sm-8">
<FORM Method="POST" Action="/utilisateurServelet">
<fieldset>
    <legend>Ajouter un utilisateur</legend>
<label>Email : 	</label>	<INPUT type=text size=20 name=email><BR>
<label>Nom   : 	</label>	<INPUT type=text size=20 name=prenom><BR>
<label>Prenom: 	</label>	<INPUT type=text size=20 name=nom><BR>
				<INPUT type=submit value=Send>
</FORM>
</fieldset>
</div>
</div>
</body>
</html>