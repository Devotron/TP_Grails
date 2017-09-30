<div id="${champsPOI}">
    <f:with bean="POI">
        <f:field property="nom"></f:field>
        <f:field property="desc" label="Description"></f:field>
        <f:field property="geopos" label="Lieu"></f:field>
        <f:field property="grpois" label="Groupes"></f:field>
        <f:field property="auteur"></f:field>
    </f:with>
    <label>Image</label>
    <input type="file" name="file" />
</div>