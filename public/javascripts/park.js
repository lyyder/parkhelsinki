
park = (function() {
    
    return {
        init: function () {
            console.log("park.init");
            if (navigator.geolocation) {
               // navigator.geolocation.getCurrentPosition()
                console.log("geolocation");
            }
        

        }

    };
}());

