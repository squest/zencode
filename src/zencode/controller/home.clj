(ns zencode.controller.home
  (:require [zencode.dbase :as dbase]
            [com.ashafa.clutch :as cl]
            [noir.util.crypt :as crip]))

(def cdb dbase/cdb)

;; well ini sekedar buat supaya ga di cached

(defn get-user
  [username]
  (->> (cl/get-view cdb "user" "byUsername" {:key username})
       (first)
       (:value)))

(defn signup
  [kmap]
  (let [{:keys [username password]} kmap
        data {:username username
              :ctype "User"
              :password (crip/encrypt password)}]
    (if (cl/put-document cdb data)
      true
      false)))

(defn valid-user?
  [kmap]
  (let [{:keys [password]}
        (get-user (:username kmap))]
    (crip/compare (:password kmap)
                  password)))


















