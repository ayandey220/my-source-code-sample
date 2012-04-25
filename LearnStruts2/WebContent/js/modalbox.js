function showModal(divID){
	document.getElementById(divID).style.visibility = "visible";
	coverScreen("visible");
}

function hideModal(divID){
	document.getElementById(divID).style.visibility = "hidden";
	coverScreen("");	
}

function coverScreen(visibility){
	var screenFrames = [parent.parent.leftFrame,
	                    parent.parent.mainFrame,
	                    parent.parent.headerFrame,
	                    parent.parent.footerFrame];
	
	for(var f in screenFrames){
		screenFrames[f].document.getElementById('overlay').style.visibility = visibility ? "visible":"";		
	}
}
