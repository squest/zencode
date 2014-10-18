(ns zencode.routes
  (:require [compojure.core :refer :all]
            [zencode.layout :as page]))

(defn homepage
  "The rendering function for homepage"
  []
  (page/render "base.html"
               {:headline "Welcome to ...."
                :title "Luminoob website"}))

(defroutes home
  (GET "/" req
       (homepage)))
