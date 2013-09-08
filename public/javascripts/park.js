var park = (function () {
    var map;

    function updateClosesParkingmeter() {
        if (navigator.geolocation) {
            navigator.geolocation.getCurrentPosition(
                function (position) {
                    resolveParkingmeters(position.coords.longitude, position.coords.latitude);
                },
                function () {
                    // position failed..
                }
            );
        }
    }

    function resolveParkingmeters(longitude, latitude) {
        map.setView(new L.LatLng(latitude, longitude), 15);
        $.get("/parkingmeters",
            {
                lng: longitude,
                lat: latitude,
                maxDistance: 1000,
                limit: 1
            },
            function (data) {
                if (data.length == 0) {
                    // no machines found in given reach
                }
                else {
                    drawOnMap({"lng": longitude, "lat": latitude}, data[0]);
                }
            });
    }

    function drawOnMap(currentLocation, parkingmeter) {
        L.mapbox.markerLayer(
            [
                {
                    type: 'Feature',
                    geometry: {
                        type: 'Point',
                        coordinates: [currentLocation.lng, currentLocation.lat]
                    },
                    properties: {
                        title: "Me!",
                        "marker-symbol": "pitch"
                    }
                },
                {
                    type: 'Feature',
                    geometry: {
                        type: 'Point',
                        coordinates: [parkingmeter.lng, parkingmeter.lat]
                    },
                    properties: {
                        title: parkingmeter.address,
                        "marker-symbol": "circle-stroked"
                    }
                }
            ]
        ).addTo(map);
    }

    return {
        init: function () {
            map = L.mapbox.map('map', 'lyyder.map-t2vxuiud');
            map.on('ready', function () {
                updateClosesParkingmeter();
            });


        }
    };
}());

