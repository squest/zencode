(ns zencode.backoffice.pages
	(:require [hiccup.core :refer :all]
						[hiccup.page :refer [html5 include-js include-css]]
						[hiccup.def :refer :all]
						[hiccup.form :refer :all]
						[hiccup.element :refer :all]))

(defelem head []
				 [:head
					[:title "This is a backoffice"]
					(include-css "/assets/normalize.css")
					(include-css "/assets/foundation.min.css")
					(include-css "/css/main-style.css")])

(defelem header []
				 [:header {:class "zpanel2"}
					[:h1 "Backoffice zencoding"]
					[:h3 "Tempat backoffice data"]])

(defelem footer []
				 [:footer
					[:hr]
					[:p "Copyright PT Zenius Education 2014"]])

(defelem login-form []
				 [:div {:class "large-centered large-5 columns"}
					[:br]
					(form-to [:put "/backoffice/login-act"]
									 [:fieldset
										[:legend "Login dong!"]
										[:div {:class "large-centered large-12 columns"}
										 (text-field {:placeholder "Username"} "username")
										 (password-field {:placeholder "Password"} "password")
										 [:button {:class "small right"} "Login"]]])])

(defhtml login [message]
				 (html5 (head)
								[:body {:class "row"}
								 (header)
								 [:br]
								 [:center [:h3 message]]
								 (login-form)
								 (footer)]))

(defhtml home [message]
				 (html5 (head)
								[:body {:class "row"}
								 (header)
								 [:br]
								 [:center
									[:h3 (str message ".. well well")]
									[:a {:href "/backoffice/logout"} "Logout"]]
								 (footer)]))


