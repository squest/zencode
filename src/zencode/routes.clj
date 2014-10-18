(ns zencode.routes
	(:require [compojure.core :refer :all]
						[zencode.layout :as page]
						[zencode.backoffice.pages :as backoffice]
						[noir.session :as session]
						[noir.response :as resp]))

(def bo-username "joni")
(def bo-password "brojol")

(defn valid-password?
	[username password]
	(and (= username bo-username)
			 (= password bo-password)))

(defroutes home
					 (GET "/" req
								"Woi kosong woi"))

(def backoffice
	(context "/backoffice" req
					 (GET "/" [request]
								(backoffice/login ""))
					 (GET "/login-try/:message" [message]
								(backoffice/login message))
					 (PUT "/login-act" req
								 (let [{:keys [params]} req
											 {:keys [username password]} params]
									 (if (valid-password? username password)
										 (do (session/put! :username username)
												 (resp/redirect "/backoffice/home"))
										 (resp/redirect "/backoffice/login-try/Salah Pasword Bro!"))))
					 (GET "/home" req
								(if-let [username (session/get :username)]
									(backoffice/home (str "Welcome bro " username))
									(resp/redirect "/backoffice/login-try/Login dulu dong bro!")))
					 (GET "/logout" req
								(do (session/clear!)
										(resp/redirect "/backoffice")))))


