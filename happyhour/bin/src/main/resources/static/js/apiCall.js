/**
 * 

 */
 
// Example GET method implementation:
async function getData(url = '') {
	
    fetch(url)
//Response resolves to a readable stream, 
//so this statement helps us convert it into 
//a static object
.then(response => response.json()) 
//Now that we have the data, let us see what it looks like in console
.then(responseData => {
    console.log(responseData);
    document.getElementById('description').innerHTML = responseData.ingredients[0].strDescription;
    document.getElementById('ingredientName').innerHTML = responseData.ingredients[0].strIngredient;
    var name = responseData.ingredients[0].strIngredient;
    
    let imgElement = document.createElement("img");
    imgElement.src = "https://www.thecocktaildb.com/images/ingredients/"+name+"-medium.png";
  
    var dv = document.getElementById('imgDiv');
	
	// remove all child nodes
	while (dv.hasChildNodes()) { 
	    dv.removeChild(dv.lastChild); 
	} 

	dv.appendChild(imgElement); 
    

});

  }
  
 
// Example GET method implementation:
async function getDrinkData(url = '') {
	
    fetch(url)
//Response resolves to a readable stream, 
//so this statement helps us convert it into 
//a static object
.then(response => response.json()) 
//Now that we have the data, let us see what it looks like in console
.then(responseData => {
    console.log(responseData);
    console.log(responseData.drinks[0].strDrink);
    document.getElementById('instructions').innerHTML = responseData.drinks[0].strInstructions;
    document.getElementById('drinkName').innerHTML = responseData.drinks[0].strDrink;
    
    
    let imgElement = document.createElement("img");
    imgElement.src = responseData.drinks[0].strDrinkThumb;
  
    var dv = document.getElementById('drinkImgDiv');
	
	// remove all child nodes
	while (dv.hasChildNodes()) { 
	    dv.removeChild(dv.lastChild); 
	} 

	dv.appendChild(imgElement); 
    
});

  }