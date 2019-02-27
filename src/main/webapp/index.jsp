<!DOCTYPE html>
<html lang="en">
<head>
   <meta charset="UTF-8">
   <title>Title</title>
</head>
<body>
<FORM Method="POST" Action="/rest/user/add">
   Email :         <INPUT type=email size=20 name=mail><BR>
   Nom   :     <INPUT type=text size=20 name=nom><BR>
   Prénom:         <INPUT type=text name=prenom><BR>
   Mot de passe : <INPUT type=password name=mdp><BR>
   <INPUT type=submit value=Send>
</FORM>

<p>Rechercher utilisateur</p>
<FORM Method="POST" Action="/rest/user/getUuser">
   Email :         <INPUT type=email size=20 name=mail><BR>
   <INPUT type=submit value=Send>
</FORM>
</body>
</html>