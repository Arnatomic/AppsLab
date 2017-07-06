<%@ include file="../imports.jsp"%>

<jsp:useBean id="style" class="org.openxava.web.style.Style" scope="request"/>

<%  
// Material Design Icons v1.4.57
// To upgrade copy the icon list from preview.html of the newer icon distribution

String [] icons = { "access-point", "access-point-network", "account", "account-alert", "account-box", "account-box-outline", "account-check", "account-circle", "account-convert", "account-key", "account-location", "account-minus", "account-multiple", "account-multiple-outline", "account-multiple-plus", "account-network", "account-off", "account-outline", "account-plus", "account-remove", "account-search", "account-star", "account-star-variant", "account-switch", "adjust", "air-conditioner", "airballoon", "airplane", "airplane-off", "airplay", "alarm", "alarm-check", "alarm-multiple", "alarm-off", "alarm-plus", "album", "alert", "alert-box", "alert-circle", "alert-octagon", "alert-outline", "alpha", "alphabetical", "amazon", "amazon-clouddrive", "ambulance", "anchor", "android", "android-debug-bridge", "android-studio", "apple", "apple-finder", "apple-ios", "apple-mobileme", "apple-safari", "appnet", "apps", "archive", "arrange-bring-forward", "arrange-bring-to-front", "arrange-send-backward", "arrange-send-to-back", "arrow-all", "arrow-bottom-drop-circle", "arrow-bottom-left", "arrow-bottom-right", "arrow-collapse", "arrow-down", "arrow-down-bold", "arrow-down-bold-circle", "arrow-down-bold-circle-outline", "arrow-down-bold-hexagon-outline", "arrow-expand", "arrow-left", "arrow-left-bold", "arrow-left-bold-circle", "arrow-left-bold-circle-outline", "arrow-left-bold-hexagon-outline", "arrow-right", "arrow-right-bold", "arrow-right-bold-circle", "arrow-right-bold-circle-outline", "arrow-right-bold-hexagon-outline", "arrow-top-left", "arrow-top-right", "arrow-up", "arrow-up-bold", "arrow-up-bold-circle", "arrow-up-bold-circle-outline", "arrow-up-bold-hexagon-outline", "assistant", "at", "attachment", "audiobook", "auto-fix", "auto-upload", "autorenew", "av-timer", "baby", "backburger", "backspace", "backup-restore", "bank", "barcode", "barcode-scan", "barley", "barrel", "basecamp", "basket", "basket-fill", "basket-unfill", "battery", "battery-10", "battery-20", "battery-30", "battery-40", "battery-50", "battery-60", "battery-70", "battery-80", "battery-90", "battery-alert", "battery-charging", "battery-charging-100", "battery-charging-20", "battery-charging-30", "battery-charging-40", "battery-charging-60", "battery-charging-80", "battery-charging-90", "battery-minus", "battery-negative", "battery-outline", "battery-plus", "battery-positive", "battery-unknown", "beach", "beaker", "beaker-empty", "beaker-empty-outline", "beaker-outline", "beats", "beer", "behance", "bell", "bell-off", "bell-outline", "bell-plus", "bell-ring", "bell-ring-outline", "bell-sleep", "beta", "bike", "bing", "binoculars", "bio", "biohazard", "bitbucket", "black-mesa", "blackberry", "blender", "blinds", "block-helper", "blogger", "bluetooth", "bluetooth-audio", "bluetooth-connect", "bluetooth-off", "bluetooth-settings", "bluetooth-transfer", "blur", "blur-linear", "blur-off", "blur-radial", "bone", "book", "book-multiple", "book-multiple-variant", "book-open", "book-open-variant", "book-variant", "bookmark", "bookmark-check", "bookmark-music", "bookmark-outline", "bookmark-outline-plus", "bookmark-plus", "bookmark-remove", "border-all", "border-bottom", "border-color", "border-horizontal", "border-inside", "border-left", "border-none", "border-outside", "border-right", "border-style", "border-top", "border-vertical", "bowling", "box", "box-cutter", "briefcase", "briefcase-check", "briefcase-download", "briefcase-upload", "brightness-1", "brightness-2", "brightness-3", "brightness-4", "brightness-5", "brightness-6", "brightness-7", "brightness-auto", "broom", "brush", "bug", "bulletin-board", "bullhorn", "bus", "cached", "cake", "cake-layered", "cake-variant", "calculator", "calendar", "calendar-blank", "calendar-check", "calendar-clock", "calendar-multiple", "calendar-multiple-check", "calendar-plus", "calendar-remove", "calendar-text", "calendar-today", "call-made", "call-merge", "call-missed", "call-received", "call-split", "camcorder", "camcorder-box", "camcorder-box-off", "camcorder-off", "camera", "camera-enhance", "camera-front", "camera-front-variant", "camera-iris", "camera-party-mode", "camera-rear", "camera-rear-variant", "camera-switch", "camera-timer", "candycane", "car", "car-battery", "car-connected", "car-wash", "carrot", "cart", "cart-outline", "cart-plus", "case-sensitive-alt", "cash", "cash-100", "cash-multiple", "cash-usd", "cast", "cast-connected", "castle", "cat", "cellphone", "cellphone-android", "cellphone-basic", "cellphone-dock", "cellphone-iphone", "cellphone-link", "cellphone-link-off", "cellphone-settings", "certificate", "chair-school", "chart-arc", "chart-areaspline", "chart-bar", "chart-histogram", "chart-line", "chart-pie", "check", "check-all", "checkbox-blank", "checkbox-blank-circle", "checkbox-blank-circle-outline", "checkbox-blank-outline", "checkbox-marked", "checkbox-marked-circle", "checkbox-marked-circle-outline", "checkbox-marked-outline", "checkbox-multiple-blank", "checkbox-multiple-blank-outline", "checkbox-multiple-marked", "checkbox-multiple-marked-outline", "checkerboard", "chemical-weapon", "chevron-double-down", "chevron-double-left", "chevron-double-right", "chevron-double-up", "chevron-down", "chevron-left", "chevron-right", "chevron-up", "church", "cisco-webex", "city", "clipboard", "clipboard-account", "clipboard-alert", "clipboard-arrow-down", "clipboard-arrow-left", "clipboard-check", "clipboard-outline", "clipboard-text", "clippy", "clock", "clock-end", "clock-fast", "clock-in", "clock-out", "clock-start", "close", "close-box", "close-box-outline", "close-circle", "close-circle-outline", "close-network", "close-octagon", "close-octagon-outline", "closed-caption", "cloud", "cloud-check", "cloud-circle", "cloud-download", "cloud-outline", "cloud-outline-off", "cloud-print", "cloud-print-outline", "cloud-upload", "code-array", "code-braces", "code-brackets", "code-equal", "code-greater-than", "code-greater-than-or-equal", "code-less-than", "code-less-than-or-equal", "code-not-equal", "code-not-equal-variant", "code-parentheses", "code-string", "code-tags", "codepen", "coffee", "coffee-to-go", "coin", "color-helper", "comment", "comment-account", "comment-account-outline", "comment-alert", "comment-alert-outline", "comment-check", "comment-check-outline", "comment-multiple-outline", "comment-outline", "comment-plus-outline", "comment-processing", "comment-processing-outline", "comment-question-outline", "comment-remove-outline", "comment-text", "comment-text-outline", "compare", "compass", "compass-outline", "console", "contact-mail", "content-copy", "content-cut", "content-duplicate", "content-paste", "content-save", "content-save-all", "contrast", "contrast-box", "contrast-circle", "cookie", "cow", "credit-card", "credit-card-multiple", "credit-card-scan", "crop", "crop-free", "crop-landscape", "crop-portrait", "crop-square", "crosshairs", "crosshairs-gps", "crown", "cube", "cube-outline", "cube-send", "cube-unfolded", "cup", "cup-water", "currency-btc", "currency-eur", "currency-gbp", "currency-inr", "currency-ngn", "currency-rub", "currency-try", "currency-usd", "cursor-default", "cursor-default-outline", "cursor-move", "cursor-pointer", "database", "database-minus", "database-plus", "debug-step-into", "debug-step-out", "debug-step-over", "decimal-decrease", "decimal-increase", "delete", "delete-variant", "delta", "deskphone", "desktop-mac", "desktop-tower", "details", "deviantart", "diamond", "dice", "dice-1", "dice-2", "dice-3", "dice-4", "dice-5", "dice-6", "directions", "disk-alert", "disqus", "disqus-outline", "division", "division-box", "dns", "domain", "dots-horizontal", "dots-vertical", "download", "drag", "drag-horizontal", "drag-vertical", "drawing", "drawing-box", "dribbble", "dribbble-box", "drone", "dropbox", "drupal", "duck", "dumbbell", "earth", "earth-off", "edge", "eject", "elevation-decline", "elevation-rise", "elevator", "email", "email-open", "email-outline", "email-secure", "emoticon", "emoticon-cool", "emoticon-devil", "emoticon-happy", "emoticon-neutral", "emoticon-poop", "emoticon-sad", "emoticon-tongue", "engine", "engine-outline", "equal", "equal-box", "eraser", "escalator", "ethernet", "ethernet-cable", "ethernet-cable-off", "etsy", "evernote", "exclamation", "exit-to-app", "export", "eye", "eye-off", "eyedropper", "eyedropper-variant", "facebook", "facebook-box", "facebook-messenger", "factory", "fan", "fast-forward", "fax", "ferry", "file", "file-chart", "file-check", "file-cloud", "file-delimited", "file-document", "file-document-box", "file-excel", "file-excel-box", "file-export", "file-find", "file-image", "file-import", "file-lock", "file-multiple", "file-music", "file-outline", "file-pdf", "file-pdf-box", "file-powerpoint", "file-powerpoint-box", "file-presentation-box", "file-send", "file-video", "file-word", "file-word-box", "file-xml", "film", "filmstrip", "filmstrip-off", "filter", "filter-outline", "filter-remove", "filter-remove-outline", "filter-variant", "fingerprint", "fire", "firefox", "fish", "flag", "flag-checkered", "flag-outline", "flag-outline-variant", "flag-triangle", "flag-variant", "flash", "flash-auto", "flash-off", "flashlight", "flashlight-off", "flattr", "flip-to-back", "flip-to-front", "floppy", "flower", "folder", "folder-account", "folder-download", "folder-google-drive", "folder-image", "folder-lock", "folder-lock-open", "folder-move", "folder-multiple", "folder-multiple-image", "folder-multiple-outline", "folder-outline", "folder-plus", "folder-remove", "folder-upload", "food", "food-apple", "food-variant", "football", "football-australian", "football-helmet", "format-align-center", "format-align-justify", "format-align-left", "format-align-right", "format-bold", "format-clear", "format-color-fill", "format-float-center", "format-float-left", "format-float-none", "format-float-right", "format-header-1", "format-header-2", "format-header-3", "format-header-4", "format-header-5", "format-header-6", "format-header-decrease", "format-header-equal", "format-header-increase", "format-header-pound", "format-indent-decrease", "format-indent-increase", "format-italic", "format-line-spacing", "format-list-bulleted", "format-list-bulleted-type", "format-list-numbers", "format-paint", "format-paragraph", "format-quote", "format-size", "format-strikethrough", "format-strikethrough-variant", "format-subscript", "format-superscript", "format-text", "format-textdirection-l-to-r", "format-textdirection-r-to-l", "format-underline", "format-wrap-inline", "format-wrap-square", "format-wrap-tight", "format-wrap-top-bottom", "forum", "forward", "foursquare", "fridge", "fridge-filled", "fridge-filled-bottom", "fridge-filled-top", "fullscreen", "fullscreen-exit", "function", "gamepad", "gamepad-variant", "gas-station", "gate", "gauge", "gavel", "gender-female", "gender-male", "gender-male-female", "gender-transgender", "ghost", "gift", "git", "github-box", "github-circle", "glass-flute", "glass-mug", "glass-stange", "glass-tulip", "glasses", "gmail", "google", "google-cardboard", "google-chrome", "google-circles", "google-circles-communities", "google-circles-extended", "google-circles-group", "google-controller", "google-controller-off", "google-drive", "google-earth", "google-glass", "google-nearby", "google-pages", "google-physical-web", "google-play", "google-plus", "google-plus-box", "google-translate", "google-wallet", "grid", "grid-off", "group", "guitar", "guitar-pick", "guitar-pick-outline", "hand-pointing-right", "hanger", "hangouts", "harddisk", "headphones", "headphones-box", "headphones-settings", "headset", "headset-dock", "headset-off", "heart", "heart-box", "heart-box-outline", "heart-broken", "heart-outline", "help", "help-circle", "hexagon", "hexagon-outline", "history", "hololens", "home", "home-modern", "home-variant", "hops", "hospital", "hospital-building", "hospital-marker", "hotel", "houzz", "houzz-box", "human", "human-child", "human-male-female", "image", "image-album", "image-area", "image-area-close", "image-broken", "image-broken-variant", "image-filter", "image-filter-black-white", "image-filter-center-focus", "image-filter-center-focus-weak", "image-filter-drama", "image-filter-frames", "image-filter-hdr", "image-filter-none", "image-filter-tilt-shift", "image-filter-vintage", "image-multiple", "import", "inbox", "information", "information-outline", "instagram", "instapaper", "internet-explorer", "invert-colors", "jeepney", "jira", "jsfiddle", "keg", "key", "key-change", "key-minus", "key-plus", "key-remove", "key-variant", "keyboard", "keyboard-backspace", "keyboard-caps", "keyboard-close", "keyboard-off", "keyboard-return", "keyboard-tab", "keyboard-variant", "label", "label-outline", "lan", "lan-connect", "lan-disconnect", "lan-pending", "language-csharp", "language-css3", "language-html5", "language-javascript", "language-php", "language-python", "language-python-text", "laptop", "laptop-chromebook", "laptop-mac", "laptop-windows", "lastfm", "launch", "layers", "layers-off", "leaf", "led-off", "led-on", "led-outline", "led-variant-off", "led-variant-on", "led-variant-outline", "library", "library-books", "library-music", "library-plus", "lightbulb", "lightbulb-outline", "link", "link-off", "link-variant", "link-variant-off", "linkedin", "linkedin-box", "linux", "lock", "lock-open", "lock-open-outline", "lock-outline", "login", "logout", "looks", "loupe", "lumx", "magnet", "magnet-on", "magnify", "magnify-minus", "magnify-plus", "mail-ru", "map", "map-marker", "map-marker-circle", "map-marker-multiple", "map-marker-off", "map-marker-radius", "margin", "markdown", "marker-check", "martini", "material-ui", "math-compass", "maxcdn", "medium", "memory", "menu", "menu-down", "menu-left", "menu-right", "menu-up", "message", "message-alert", "message-draw", "message-image", "message-outline", "message-processing", "message-reply", "message-reply-text", "message-text", "message-text-outline", "message-video", "microphone", "microphone-off", "microphone-outline", "microphone-settings", "microphone-variant", "microphone-variant-off", "microsoft", "minus", "minus-box", "minus-circle", "minus-circle-outline", "minus-network", "monitor", "monitor-multiple", "more", "motorbike", "mouse", "mouse-off", "mouse-variant", "mouse-variant-off", "movie", "multiplication", "multiplication-box", "music-box", "music-box-outline", "music-circle", "music-note", "music-note-eighth", "music-note-half", "music-note-off", "music-note-quarter", "music-note-sixteenth", "music-note-whole", "nature", "nature-people", "navigation", "needle", "nest-protect", "nest-thermostat", "newspaper", "nfc", "nfc-tap", "nfc-variant", "nodejs", "note", "note-outline", "note-plus", "note-plus-outline", "note-text", "notification-clear-all", "numeric", "numeric-0-box", "numeric-0-box-multiple-outline", "numeric-0-box-outline", "numeric-1-box", "numeric-1-box-multiple-outline", "numeric-1-box-outline", "numeric-2-box", "numeric-2-box-multiple-outline", "numeric-2-box-outline", "numeric-3-box", "numeric-3-box-multiple-outline", "numeric-3-box-outline", "numeric-4-box", "numeric-4-box-multiple-outline", "numeric-4-box-outline", "numeric-5-box", "numeric-5-box-multiple-outline", "numeric-5-box-outline", "numeric-6-box", "numeric-6-box-multiple-outline", "numeric-6-box-outline", "numeric-7-box", "numeric-7-box-multiple-outline", "numeric-7-box-outline", "numeric-8-box", "numeric-8-box-multiple-outline", "numeric-8-box-outline", "numeric-9-box", "numeric-9-box-multiple-outline", "numeric-9-box-outline", "numeric-9-plus-box", "numeric-9-plus-box-multiple-outline", "numeric-9-plus-box-outline", "nutrition", "octagon", "octagon-outline", "odnoklassniki", "office", "oil", "oil-temperature", "omega", "onedrive", "open-in-app", "open-in-new", "opera", "ornament", "ornament-variant", "outbox", "owl", "package", "package-down", "package-up", "package-variant", "package-variant-closed", "palette", "palette-advanced", "panda", "pandora", "panorama", "panorama-fisheye", "panorama-horizontal", "panorama-vertical", "panorama-wide-angle", "paper-cut-vertical", "paperclip", "parking", "pause", "pause-circle", "pause-circle-outline", "pause-octagon", "pause-octagon-outline", "paw", "pen", "pencil", "pencil-box", "pencil-box-outline", "pencil-lock", "pencil-off", "percent", "pharmacy", "phone", "phone-bluetooth", "phone-forward", "phone-hangup", "phone-in-talk", "phone-incoming", "phone-locked", "phone-log", "phone-missed", "phone-outgoing", "phone-paused", "phone-settings", "phone-voip", "pi", "pi-box", "pig", "pill", "pin", "pin-off", "pine-tree", "pine-tree-box", "pinterest", "pinterest-box", "pizza", "play", "play-box-outline", "play-circle", "play-circle-outline", "play-pause", "play-protected-content", "playlist-minus", "playlist-play", "playlist-plus", "playlist-remove", "playstation", "plus", "plus-box", "plus-circle", "plus-circle-multiple-outline", "plus-circle-outline", "plus-network", "plus-one", "pocket", "pokeball", "polaroid", "poll", "poll-box", "polymer", "popcorn", "pound", "pound-box", "power", "power-settings", "power-socket", "presentation", "presentation-play", "printer", "printer-3d", "printer-alert", "professional-hexagon", "projector", "projector-screen", "pulse", "puzzle", "qrcode", "qrcode-scan", "quadcopter", "quality-high", "quicktime", "radar", "radiator", "radio", "radio-handheld", "radio-tower", "radioactive", "radiobox-blank", "radiobox-marked", "raspberrypi", "ray-end", "ray-end-arrow", "ray-start", "ray-start-arrow", "ray-start-end", "ray-vertex", "rdio", "read", "readability", "receipt", "record", "record-rec", "recycle", "reddit", "redo", "redo-variant", "refresh", "regex", "relative-scale", "reload", "remote", "rename-box", "repeat", "repeat-off", "repeat-once", "replay", "reply", "reply-all", "reproduction", "resize-bottom-right", "responsive", "rewind", "ribbon", "road", "road-variant", "rocket", "rotate-3d", "rotate-left", "rotate-left-variant", "rotate-right", "rotate-right-variant", "router-wireless", "routes", "rss", "rss-box", "ruler", "run", "sale", "satellite", "satellite-variant", "scale", "scale-bathroom", "school", "screen-rotation", "screen-rotation-lock", "screwdriver", "script", "sd", "seal", "seat-flat", "seat-flat-angled", "seat-individual-suite", "seat-legroom-extra", "seat-legroom-normal", "seat-legroom-reduced", "seat-recline-extra", "seat-recline-normal", "security", "security-network", "select", "select-all", "select-inverse", "select-off", "selection", "send", "server", "server-minus", "server-network", "server-network-off", "server-off", "server-plus", "server-remove", "server-security", "settings", "settings-box", "shape-plus", "share", "share-variant", "shield", "shield-outline", "shopping", "shopping-music", "shredder", "shuffle", "shuffle-disabled", "shuffle-variant", "sigma", "sign-caution", "signal", "silverware", "silverware-fork", "silverware-spoon", "silverware-variant", "sim", "sim-alert", "sim-off", "sitemap", "skip-backward", "skip-forward", "skip-next", "skip-previous", "skype", "skype-business", "slack", "sleep", "sleep-off", "smoking", "smoking-off", "snapchat", "snowman", "sofa", "sort", "sort-alphabetical", "sort-ascending", "sort-descending", "sort-numeric", "sort-variant", "soundcloud", "source-fork", "source-pull", "speaker", "speaker-off", "speedometer", "spellcheck", "spotify", "spotlight", "spotlight-beam", "square-inc", "square-inc-cash", "stackoverflow", "stairs", "star", "star-circle", "star-half", "star-off", "star-outline", "steam", "steering", "step-backward", "step-backward-2", "step-forward", "step-forward-2", "stethoscope", "stocking", "stop", "store", "store-24-hour", "stove", "subway", "sunglasses", "swap-horizontal", "swap-vertical", "swim", "switch", "sword", "sync", "sync-alert", "sync-off", "tab", "tab-unselected", "table", "table-column-plus-after", "table-column-plus-before", "table-column-remove", "table-column-width", "table-edit", "table-large", "table-row-height", "table-row-plus-after", "table-row-plus-before", "table-row-remove", "tablet", "tablet-android", "tablet-ipad", "tag", "tag-faces", "tag-multiple", "tag-outline", "tag-text-outline", "target", "taxi", "teamviewer", "telegram", "television", "television-guide", "temperature-celsius", "temperature-fahrenheit", "temperature-kelvin", "tennis", "tent", "terrain", "text-to-speech", "text-to-speech-off", "texture", "theater", "theme-light-dark", "thermometer", "thermometer-lines", "thumb-down", "thumb-down-outline", "thumb-up", "thumb-up-outline", "thumbs-up-down", "ticket", "ticket-account", "ticket-confirmation", "tie", "timelapse", "timer", "timer-10", "timer-3", "timer-off", "timer-sand", "timetable", "toggle-switch", "toggle-switch-off", "tooltip", "tooltip-edit", "tooltip-image", "tooltip-outline", "tooltip-outline-plus", "tooltip-text", "tor", "traffic-light", "train", "tram", "transcribe", "transcribe-close", "transfer", "tree", "trello", "trending-down", "trending-neutral", "trending-up", "triangle", "triangle-outline", "trophy", "trophy-award", "trophy-outline", "trophy-variant", "trophy-variant-outline", "truck", "truck-delivery", "tshirt-crew", "tshirt-v", "tumblr", "tumblr-reblog", "twitch", "twitter", "twitter-box", "twitter-circle", "twitter-retweet", "ubuntu", "umbraco", "umbrella", "umbrella-outline", "undo", "undo-variant", "unfold-less", "unfold-more", "ungroup", "untappd", "upload", "usb", "vector-arrange-above", "vector-arrange-below", "vector-circle", "vector-circle-variant", "vector-combine", "vector-curve", "vector-difference", "vector-difference-ab", "vector-difference-ba", "vector-intersection", "vector-line", "vector-point", "vector-polygon", "vector-polyline", "vector-selection", "vector-square", "vector-triangle", "vector-union", "verified", "vibrate", "video", "video-off", "video-switch", "view-agenda", "view-array", "view-carousel", "view-column", "view-dashboard", "view-day", "view-grid", "view-headline", "view-list", "view-module", "view-quilt", "view-stream", "view-week", "vimeo", "vine", "vk", "vk-box", "vk-circle", "voicemail", "volume-high", "volume-low", "volume-medium", "volume-off", "vpn", "walk", "wallet", "wallet-giftcard", "wallet-membership", "wallet-travel", "wan", "watch", "watch-export", "watch-import", "water", "water-off", "water-percent", "water-pump", "weather-cloudy", "weather-fog", "weather-hail", "weather-lightning", "weather-night", "weather-partlycloudy", "weather-pouring", "weather-rainy", "weather-snowy", "weather-sunny", "weather-sunset", "weather-sunset-down", "weather-sunset-up", "weather-windy", "weather-windy-variant", "web", "webcam", "weight", "weight-kilogram", "whatsapp", "wheelchair-accessibility", "white-balance-auto", "white-balance-incandescent", "white-balance-irradescent", "white-balance-sunny", "wifi", "wifi-off", "wii", "wikipedia", "window-close", "window-closed", "window-maximize", "window-minimize", "window-open", "window-restore", "windows", "wordpress", "worker", "wrap", "wrench", "wunderlist", "xbox", "xbox-controller", "xbox-controller-off", "xda", "xing", "xing-box", "xing-circle", "xml", "yeast", "yelp", "youtube-play", "zip-box" };		
String app = request.getParameter("application");
String module = request.getParameter("module");
// We don't user <xava:link /> because of performance, 1ms each call for 1000 calls = 1 second, too much.		
%>
<div class="<%=style.getIconsList()%>">  
<% for (String icon: icons) { %>
	<i class="mdi mdi-<%=icon%>" title="<%=icon%>" onclick="openxava.executeAction('<%=app%>', '<%=module%>', '', false, 'Icon.choose', 'icon=<%=icon%>')"></i>
<% } %>
</div>
