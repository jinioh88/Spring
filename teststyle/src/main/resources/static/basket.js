var basketManager = (function () {
   var getAll = function (obj, callback) {
     console.log("get All Basket");
     $.getJSON('/api/basket/'+obj,callback);
   };

   var add = function (obj, callback) {
       console.log("add Basket");
   };

   return {
    getAll: getAll,
    add: add
   }
})();