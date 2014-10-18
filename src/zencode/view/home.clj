(ns zencode.view.home
	(:require [hiccup.core :refer :all]
						[hiccup.page :refer [html5 include-js include-css]]
						[hiccup.def :refer :all]
						[hiccup.form :refer :all]
						[hiccup.element :refer :all]))

(defelem head []
				 [:head
					[:title "This is the site of zen coding"]
					(include-css "/assets/normalize.css")
					(include-css "/assets/foundation.min.css")
					(include-css "/css/main-style.css")])

(defelem header []
				 [:header {:class "zpanel2 large-12 columns"}
					[:div {:class "large-8 columns"}
					 [:h1 "Zencoding"]
					 [:h3 "Welcome to geek heaven"]]
					[:div {:class "large-4 columns"}
					 [:a {:href "/login"} "Login | "]
					 [:a {:href "/logout"} "Logout | "]
					 [:a {:href "/signup"} "Signup"]]])

(defelem footer []
				 [:footer
					[:hr]
					[:p "Copyright PT Zenius Education 2014"]])

(defelem login-form [action]
				 [:div {:class "large-centered large-5 columns"}
					[:br]
					(form-to [:post (case action
													 :login "/login-act"
													 :signup "/signup-act")]
									 [:fieldset
										[:legend (case action
															 :login "Login dong"
															 :signup "Makasiih udah mau signup :)")]
										[:div {:class "large-centered large-12 columns"}
										 (text-field {:placeholder "Username"} "username")
										 (password-field {:placeholder "Password"} "password")
										 [:button {:class "small right"} "Login"]]])])

(defhtml userform [action]
				 (html5 (head)
								[:body {:class "row"}
								 (header)
								 [:br]
								 (login-form action)
								 (footer)]))

(defhtml home [message]
				 (html5 (head)
								[:body {:class "row"}
								 (header)
								 [:br]
								 (footer)]))



