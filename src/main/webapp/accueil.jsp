<table>
    <c:forEach items="${utilisateurs}" var="utilisateur">
        <tr>
            <td>${utilisateur.EMAIL}</td>
            <td>${utilisateur.PRENOM}</td>
            <td>${utilisateur.NOM}</td>
//             <td><a href="utilisateur?id=${utilisateur.id}">detail</a></td>
        </tr>
    </c:forEach>
</table>