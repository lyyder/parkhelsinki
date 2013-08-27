var park = (function () {
    var map;

    function updateClosesParkingmeter() {
        if (navigator.geolocation) {
            navigator.geolocation.getCurrentPosition(
                function (position) {
                    map.setView(new L.LatLng(position.coords.latitude, position.coords.longitude), 15);
                    $.get("/parkingmeters",
                        {
                            lng: position.coords.longitude,
                            lat: position.coords.latitude,
                            maxDistance: 1000,
                            limit: 1
                        },
                        function (data) {
                            drawOnMap({"lng": position.coords.longitude, "lat": position.coords.latitude}, data[0]);
                        });
                },
                function () {
                    // location error function
                }
            );
        }
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

