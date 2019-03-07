<!DOCTYPE html>
<html lang="en">
<head>
   <meta charset="UTF-8">
   <title>Title</title>
</head>
<body>
<FORM Method="POST" Action="/rest/user/add">
   Email :         <INPUT type=email size=20 name=mail><BR>
   Nom   :     	   <INPUT type=text size=20 name=nom><BR>
   Prénom:         <INPUT type=text name=prenom><BR>
   Mot de passe : <INPUT type=password name=mdp><BR>
   <INPUT type=submit value=Send>
</FORM>

<p>Rechercher utilisateur</p>
<FORM Method="GET" Action="/rest/user/getUser">
   Email :         <INPUT type=email size=20 name=mail><BR>
   <INPUT type=submit value=Send>
</FORM>
<p>Supprimer un  utilisateur via email</p>
<FORM Method="POST" Action="/rest/user/delete">
   Email :         <INPUT type=email size=20 name=mail><BR>
   <INPUT type=submit value=Send>
</FORM>
<p>Liste utilisateur</p>
<FORM Method="GET" Action="/rest/user/alluser">
   <INPUT type=submit value=Send>
</FORM>
<p>Add sondage</p>
<FORM Method="POST" Action="/rest/sondage/add">
   Lien   :     	   <INPUT type=text size=20 name=lienWeb><BR>
   Createur :          <INPUT type=email size=20 name=mailCreateur><BR>
      <INPUT type=submit value=Send>
</FORM>
</body>
</html>