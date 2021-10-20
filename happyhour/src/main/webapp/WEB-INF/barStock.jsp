<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!-- c:out ; c:forEach etc. -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- JSP functions -->
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!-- spring forms -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<style>
.collapsible {
  background-color: #777;
  color: white;
  cursor: pointer;
  padding: 5px;
  width: 10%;
  border: none;
  text-align: center;
  outline: none;
  font-size: 15px;
}

.active, .collapsible:hover {
  background-color: #555;
}

.content1 {
  padding: 0 18px;
  display: none;
  overflow: hidden;
  background-color: #f1f1f1;
}
</style>
<link rel="stylesheet" type="text/css" href="/css/barStockStyling.css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-uWxY/CJNBR+1zjPWmfnSnVxwRheevXITnMqoEIeG1LJrdI0GlVs/9cVSyPYXdcSF"crossorigin="anonymous">
<link rel="stylesheet" href="//code.jquery.com/ui/1.13.0/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script src="https://code.jquery.com/ui/1.13.0/jquery-ui.js"></script>
<script>
  $( function() {
    var allIngredients = ["Vodka","Gin","Rum","Tequila","Scotch","Absolut Kurant","Absolut Peppar","Absolut Vodka","Advocaat","Aejo Rum","Aftershock","Agave Syrup","Ale","Allspice","Almond Flavoring","Almond","Amaretto","Angelica Root","Angostura Bitters","Anis","Anise","Anisette","Aperol","Apfelkorn","Apple Brandy","Apple Cider","Apple Juice","Apple Schnapps","Apple","Applejack","Apricot Brandy","Apricot Nectar","Apricot","Aquavit","Asafoetida","Anejo Rum","Bacardi Limon","Bacardi","Baileys Irish Cream","Banana Liqueur","Banana Rum","Banana Syrup","Banana","Barenjager","Basil","Beef Stock","Beer","Benedictine","Berries","Bitter lemon","Bitters","Black Pepper","Black Rum","Black Sambuca","Blackberries","Blackberry Brandy","Blackberry Schnapps","Blackcurrant Cordial","Blackcurrant Schnapps","Blackcurrant Squash","Blended Whiskey","Blue Curacao","Blue Maui","Blueberries","Blueberry Schnapps","Bourbon","Brandy","Brown Sugar","Butter","Butterscotch Schnapps","Cachaca","Calvados","Campari","Canadian Whisky","Candy","Cantaloupe","Caramel Coloring","Carbonated Soft Drink","Carbonated Water","Cardamom","Cayenne Pepper","Celery Salt","Celery","Chambord Raspberry Liqueur","Champagne","Cherries","Cherry Brandy","Cherry Cola","Cherry Grenadine","Cherry Heering","Cherry Juice","Cherry Liqueur","Cherry","Chocolate Ice-cream","Chocolate Liqueur","Chocolate Milk","Chocolate Syrup","Chocolate","Cider","Cinnamon Schnapps","Cinnamon","Citrus Vodka","Clamato Juice","Cloves","Club Soda","Coca-Cola","Cocktail Onion","Cocoa Powder","Coconut Cream","Coconut Liqueur","Coconut Milk","Coconut Rum","Coconut Syrup","Coffee Brandy","Coffee Liqueur","Coffee","Cognac","Cointreau","Cola","Cold Water","Condensed Milk","Coriander","Corn Syrup","Cornstarch","Corona","Cranberries","Cranberry Juice","Cranberry Liqueur","Cranberry Vodka","Cream of Coconut","Cream Sherry","Cream Soda","Cream","Creme De Almond","Creme De Banane","Creme De Cacao","Creme De Cassis","Creme De Noyaux","Creme Fraiche","Crown Royal","Crystal Light","Cucumber","Cumin Powder","Cumin Seed","Curacao","Cynar","Daiquiri Mix","Dark Chocolate","Dark Creme De Cacao","Dark Rum","Dark Soy Sauce","Demerara Sugar","Dr. Pepper","Drambuie","Dried Oregano","Dry Vermouth","Dubonnet Blanc","Dubonnet Rouge","Egg White","Egg Yolk","Egg","Eggnog","Erin Cream","Espresso","Everclear","Fanta","Fennel Seeds","Firewater","Flaked Almonds","Food Coloring","Forbidden Fruit","Frangelico","Fresca","Fresh Basil","Fresh Lemon Juice","Fruit Juice","Fruit Punch","Fruit","Galliano","Garlic Sauce","Gatorade","Ginger Ale","Ginger Beer","Ginger","Glycerine","Godiva Liqueur","Gold rum","Gold Tequila","Goldschlager","Grain Alcohol","Grand Marnier","Granulated Sugar","Grape juice","Grape soda","Grapefruit Juice","Grapes","Green Chartreuse","Green Creme de Menthe","Green Ginger Wine","Green Olives","Grenadine","Ground Ginger","Guava juice","Guinness stout","Guinness","Half-and-half","Hawaiian punch","Hazelnut liqueur","Heavy cream","Honey","Hooch","Hot Chocolate","Hot Damn","Hot Sauce","Hpnotiq","Ice-Cream","Ice","Iced tea","Irish cream","Irish Whiskey","Jack Daniels","Jello","Jelly","Jagermeister","Jim Beam","Johnnie Walker","Kahlua","Key Largo Schnapps","Kirschwasser","Kiwi liqueur","Kiwi","Kool-Aid","Kummel","Lager","Lemon Juice","Lemon Peel","Lemon soda","Lemon vodka","Lemon-lime soda","lemon-lime","lemon","Lemonade","Licorice Root","Light Cream","Light Rum","Lillet","Lime juice cordial","Lime Juice","Lime liqueur","Lime Peel","Lime vodka","Lime","Limeade","Madeira","Malibu Rum","Mandarin","Mandarine napoleon","Mango","Maple syrup","Maraschino cherry juice","Maraschino Cherry","Maraschino Liqueur","Margarita mix","Marjoram leaves","Marshmallows","Maui","Melon Liqueur","Melon Vodka","Mezcal","Midori Melon Liqueur","Midori","Milk","Mint syrup","Mint","Mountain Dew","Nutmeg","Olive Oil","Olive","Onion","Orange Bitters","Orange Curacao","Orange Juice","Orange liqueur","Orange Peel","Orange rum","Orange Soda","Orange spiral","Orange vodka","Orange","Oreo cookie","Orgeat Syrup","Ouzo","Oyster Sauce","Papaya juice","Papaya","Parfait amour","Passion fruit juice","Passion fruit syrup","Passoa","Peach brandy","Peach juice","Peach liqueur","Peach Nectar","Peach Schnapps","Peach Vodka","Peach","Peachtree schnapps","Peanut Oil","Pepper","Peppermint extract","Peppermint Schnapps","Pepsi Cola","Pernod","Peychaud bitters","Pina colada mix","Pineapple Juice","Pineapple rum","Pineapple vodka","Pineapple-orange-banana juice","Pineapple","Pink lemonade","Pisang Ambon","Pisco","Plain Chocolate","Plain Flour","Plums","Port","Powdered Sugar","Purple passion","Raisins","Raspberry cordial","Raspberry Jam","Raspberry Juice","Raspberry Liqueur","Raspberry schnapps","Raspberry syrup","Raspberry Vodka","Red Chile Flakes","Red Chili Flakes","Red Hot Chili Flakes","Red Wine","Rhubarb","Ricard","Rock Salt","Root beer schnapps","Root beer","Roses sweetened lime juice","Rosewater","Rumple Minze","Rye Whiskey","Sake","Salt","Sambuca","Sarsaparilla","Schnapps","Schweppes Lemon","Schweppes Russchian","Sherbet","Sherry","Sirup of roses","Sloe Gin","Soda Water","Sour Apple Pucker","Sour Mix","Southern Comfort","Soy Milk","Soy Sauce","Soya Milk","Soya Sauce","Spiced Rum","Sprite","Squeezed Orange","Squirt","Strawberries","Strawberry juice","Strawberry liqueur","Strawberry Schnapps","Strawberry syrup","Sugar Syrup","Sugar","Sunny delight","Surge","Swedish punsch","Sweet and Sour","Sweet Cream","Sweet Vermouth","Tabasco Sauce","Tang","Tawny port","Tea","Tennessee whiskey","Tequila rose","Tia Maria","Tomato Juice","Tomato","Tonic Water","Triple Sec","Tropicana","Tuaca","Vanilla extract","Vanilla Ice-Cream","Vanilla liqueur","Vanilla schnapps","Vanilla syrup","Vanilla vodka","Vanilla","Vermouth","Vinegar","Water","Watermelon schnapps","Whipped Cream","Whipping Cream","White chocolate liqueur","White Creme de Menthe","White grape juice","White port","White Rum","White Vinegar","White Wine","Wild Turkey","Wildberry schnapps","Wine","Worcestershire Sauce","Wormwood","Yeast","Yellow Chartreuse","Yoghurt","Yukon Jack","Zima","Caramel Sauce","Chocolate Sauce","Lillet Blanc","Peach Bitters","Mini-snickers bars","Prosecco","Salted Chocolate","Martini Rosso","Martini Bianco","Martini Extra Dry","Fresh Lime Juice","Fresh Mint","Rosemary","Habanero Peppers","Ilegal Joven mezcal","Elderflower cordial","Rosso Vermouth","Creme de Violette","Cocchi Americano","White Vermouth","Dry Curacao","Nocino","Averna","Ramazzotti","Fernet-Branca","Allspice Dram","Falernum","Singani","Arrack","Blackstrap rum","Ginger Syrup","Honey syrup","Blended Scotch","Islay single malt Scotch","151 proof rum","7-up","Absinthe","Absolut citron","Creme de Mure","Olive Brine","Pineapple Syrup","St. Germain","Lavender","Whiskey","Whisky","Pomegranate juice","Watermelon","Chareau","Cinnamon Whisky","Red Bull","Diet Coke","Rosemary Syrup","Figs","Thyme","Orange Slice","Blood Orange","Amaro Montenegro","Ruby Port","Rose"];
    $( "#ingredients" ).autocomplete({source: allIngredients});
  } );
  </script>
<meta charset="ISO-8859-1">
<title>${loggedUser.firstName}'s Bar</title>
</head>
<body>
<div class="container-fluid">
		<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
			<div class="container-fluid">
				<a class="navbar-brand" href="/happyhour">Home</a>
				<div class="collapse navbar-collapse" id="navbarNav">
					<ul class="navbar-nav">
						<li class="nav-item">
							
							
							
						</li>		
					</ul>
					<ul class="navbar-nav">
						<li class="nav-item"><a class="nav-link active"
							aria-current="page" href="#">Favorites</a>
						</li>	
					</ul>
				</div>
				<c:choose>
				<c:when test="${loggedUser.id != null}">
					<a class="navbar-brand" href="/logout"> Logout </a>
				</c:when>
				<c:otherwise>
					<a class="navbar-brand" href="/login"> Login </a>
				</c:otherwise>
				</c:choose>
			</div>
		</nav>
	</div>
	
	
	
${suggestions.size()} possibilities:
<button type="button" class="collapsible"><h3>Suggestions</h3></button>
<div class="content1">
<c:forEach items="${suggestions}" var="suggestion">
    ${suggestion}<br>
</c:forEach>
</div>
    



	<div class="container">
	<h4>There are ${fn:length(allDrinks)} Drinks in the Database.</h4>
<!-- Search Results Go Here -->		
	<div class="container">
   <div class=pantry_container>
   <h5>What's on hand:</h5>
   	<p>${pantry}</p>
   </div>
   <p><c:out value="${message}" /></p>
    <p><c:out value="${error}" /></p>
    <form method="post" action="/happyhour/mybar/add">
    	<div class="ui-widget">
  			<input id="ingredients" name="ingredient" placeholder="search for ingredients!">
		</div>
        <input type="submit" value="Add"/>
    </form>
    
    <h4>Here's what you can make now!</h4>
		<div class="row g-3">
			<c:forEach items="${allDrinks}" var="drink">	
				<c:if test="${pantry.containsAll(drink.getIngredientList())}">						
				<div class="col-12 col-md-6 col-lg-4">
					<div class="card">
						<a href="/drinks/${drink.apiId}"><img src="${drink.imgThumb}" class="card-img-top" alt="" /></a>
					    <div class="card-body">
						    <h5 class="card-title"><a href="/drinks/${drink.apiId}">${drink.name}</a></h5>
						    <c:if test="${pantry.containsAll(drink.getIngredientList())}">
								<p class="card-text" style="color: green; font-size: 20px;">You can make this drink!</p>
							</c:if>
							<p class="card-text"><small class="text-muted">
								<c:forEach items="${drink.getIngredientList()}" var="ingredient">
									<span
									<c:choose>
										<c:when test="${pantry.contains(ingredient)}"> 
											style="color: green;"
										</c:when>
										<c:otherwise>
											style="color: red;"
										</c:otherwise>
									</c:choose>>
									${ingredient},
									</span>
								</c:forEach>
								</small>
							</p>
						</div>
					</div>							
				</div>
				</c:if>							
			</c:forEach>
		</div>
		
	</div>	
	
	</div>
	
	<script>
var coll = document.getElementsByClassName("collapsible");
var i;

for (i = 0; i < coll.length; i++) {
  coll[i].addEventListener("click", function() {
    this.classList.toggle("active");
    var content = this.nextElementSibling;
    if (content.style.display === "block") {
      content.style.display = "none";
    } else {
      content.style.display = "block";
    }
  });
}
</script>
</body>
</html>