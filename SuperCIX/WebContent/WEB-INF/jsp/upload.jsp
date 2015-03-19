<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<html>
<head>
<link rel="canonical" href="http://codepen.io/wallaceerick/pen/fEdrz/" />

<link rel='stylesheet'
	href='//ajax.googleapis.com/ajax/libs/jqueryui/1.11.2/themes/smoothness/jquery-ui.css'>
<style class="cp-pen-styles">
@import url("http://fonts.googleapis.com/css?family=Lato");

* {
	margin: 0;
	padding: 0;
	-moz-box-sizing: border-box;
	-webkit-box-sizing: border-box;
	box-sizing: border-box;
}

body {
	font-family: Lato, Arial;
	color: #fff;
	padding: 55px 25px;
	background-color: #e74c3c;
}

h1 {
	font-weight: normal;
	font-size: 40px;
	font-weight: normal;
	text-transform: uppercase;
}

h1 span {
	font-size: 13px;
	display: block;
	padding-left: 4px;
}

p {
	margin-top: 200px;
}

p a {
	text-transform: uppercase;
	text-decoration: none;
	display: inline-block;
	color: #fff;
	padding: 5px 10px;
	margin: 0 5px;
	background-color: #b83729;
	-moz-transition: all 0.2s ease-in;
	-o-transition: all 0.2s ease-in;
	-webkit-transition: all 0.2s ease-in;
	transition: all 0.2s ease-in;
}

p a:hover {
	background-color: #ab3326;
}

.custom-file-upload-hidden {
	display: none;
	visibility: hidden;
	position: absolute;
	left: -9999px;
}

.custom-file-upload {
	display: block;
	width: auto;
	font-size: 16px;
	margin-top: 30px;
}

.custom-file-upload label {
	display: block;
	margin-bottom: 5px;
}

.file-upload-wrapper {
	position: relative;
	margin-bottom: 5px;
}

.file-upload-input {
	width: 300px;
	color: #fff;
	font-size: 16px;
	padding: 11px 17px;
	border: none;
	background-color: #c0392b;
	-moz-transition: all 0.2s ease-in;
	-o-transition: all 0.2s ease-in;
	-webkit-transition: all 0.2s ease-in;
	transition: all 0.2s ease-in;
	float: left;
	/* IE 9 Fix */
}

.file-upload-input:hover, .file-upload-input:focus {
	background-color: #ab3326;
	outline: none;
}

.file-upload-button {
	cursor: pointer;
	display: inline-block;
	color: #fff;
	font-size: 16px;
	text-transform: uppercase;
	padding: 11px 20px;
	border: none;
	margin-left: -1px;
	background-color: #962d22;
	float: left;
	/* IE 9 Fix */
	-moz-transition: all 0.2s ease-in;
	-o-transition: all 0.2s ease-in;
	-webkit-transition: all 0.2s ease-in;
	transition: all 0.2s ease-in;
}

.file-upload-button:hover {
	background-color: #6d2018;
}
</style>
<style type="text/css">
#header h1 {
	color: #fff;
	text-shadow: 0 0 5px #fff, 0 0 10px #fff, 0 0 15px #fff, 0 0 20px
		#52FF2D, 0 0 30px #52FF2D, 0 0 40px #52FF2D, 0 0 50px #52FF2D, 0 0
		75px #52FF2D;
	letter-spacing: 5px;
	font: 80px 'MisoRegular';
}

@import url("http://fonts.googleapis.com/css?family=Lato");

$
background: #e74c3c ;
 $file-upload-color: #c0392b ;
 $file-upload-size: 300px ;

* {
	margin: 0;
	padding: 0;
	@
	include
	box-sizing(border-box);
}

body {
	font-family: Lato, Arial;
	color: #fff;
	padding: 55px 25px;
	background-color: $background;
}

h1 {
	font-weight: normal;
	font-size: 40px;
	font-weight: normal;
	text-transform: uppercase; span { font-size : 13px;
	display: block;
	padding-left: 4px;
}

}
p {
	margin-top: 200px; a { text-transform : uppercase;
	text-decoration: none;
	display: inline-block;
	color: #fff;
	padding: 5px 10px;
	margin: 0 5px;
	background-color: darken($ file-upload-color, 2);
	@
	include
	transition(all
	0.2s
	ease-in);
	&:
	hover
	{
	background-color
	:
	darken(
	$
	file-upload-color
	,
	5
	);
}

}
}
.custom-file-upload-hidden {
	display: none;
	visibility: hidden;
	position: absolute;
	left: -9999px;
}

.custom-file-upload {
	display: block;
	width: auto;
	font-size: 16px;
	margin-top: 30px; //
	border: 1px solid #ccc; label { display : block;
	margin-bottom: 5px;
}

}
.file-upload-wrapper {
	position: relative;
	margin-bottom: 5px; //
	border: 1px solid #ccc;
}

.file-upload-input {
	width: $file-upload-size;
	color: #fff;
	font-size: 16px;
	padding: 11px 17px;
	border: none;
	background-color: $file-upload-color; @ include transition(all 0.2s
	ease-in);
	float: left; /* IE 9 Fix */ &: hover , & : focus { 
        background-color : darken( $ file-upload-color, 5);
	outline: none;
}

}
.file-upload-button {
	cursor: pointer;
	display: inline-block;
	color: #fff;
	font-size: 16px;
	text-transform: uppercase;
	padding: 11px 20px;
	border: none;
	margin-left: -1px;
	background-color: darken($ file-upload-color, 10);
	float: left; /* IE 9 Fix */
	@
	include
	transition(all
	0.2s
	ease-in);
	&:
	hover
	{
	background-color
	:
	darken(
	$
	file-upload-color
	,
	20
	);
}
}
</style>

</head>
<body>

	<form:form method="POST" id="fileupload" action="uploaded.do"
		modelAttribute="uploadForm" enctype="multipart/form-data">
		<h1>
			SUPER CIX <span>${message}</span>
		</h1>

		<div class="custom-file-upload">
			<!--<label for="file">File: </label>-->
			<div class="file-upload-wrapper">
				<input type="file" id="file" name="uploadedFile" multiple=""
					class="custom-file-upload-hidden" tabindex="-1">
			</div>
		</div>
		<br>
		<br><br><br>
		<hr>
		<br>
		<input class="file-upload-button" type="submit" value="Convert to RWD">
	</form:form>
	<script
		src="//ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
	<script
		src="//ajax.googleapis.com/ajax/libs/jqueryui/1.11.2/jquery-ui.min.js"></script>
	<script>
;
(function ($) {
    var multipleSupport = typeof $('<input/>')[0].multiple !== 'undefined', isIE = /msie/i.test(navigator.userAgent);
    $.fn.customFile = function () {
        return this.each(function () {
            var $file = $(this).addClass('custom-file-upload-hidden'), $wrap = $('<div class="file-upload-wrapper">'), $input = $('<input type="text" class="file-upload-input" />'), $button = $('<button type="button" class="file-upload-button">Select a File</button>'), $label = $('<label class="file-upload-button" for="' + $file[0].id + '">Select a File</label>');
            $file.css({
                position: 'absolute',
                left: '-9999px'
            });
            $wrap.insertAfter($file).append($file, $input, isIE ? $label : $button);
            $file.attr('tabIndex', -1);
            $button.attr('tabIndex', -1);
            $button.click(function () {
                $file.focus().click();
            });
            $file.change(function () {
                var files = [], fileArr, filename;
                if (multipleSupport) {
                    fileArr = $file[0].files;
                    for (var i = 0, len = fileArr.length; i < len; i++) {
                        files.push(fileArr[i].name);
                    }
                    filename = files.join(', ');
                } else {
                    filename = $file.val().split('\\').pop();
                }
                $input.val(filename).attr('title', filename).focus();
            });
            $input.on({
                blur: function () {
                    $file.trigger('blur');
                },
                keydown: function (e) {
                    if (e.which === 13) {
                        if (!isIE) {
                            $file.trigger('click');
                        }
                    } else if (e.which === 8 || e.which === 46) {
                        $file.replaceWith($file = $file.clone(true));
                        $file.trigger('change');
                        $input.val('');
                    } else if (e.which === 9) {
                        return;
                    } else {
                        return false;
                    }
                }
            });
        });
    };
    if (!multipleSupport) {
        $(document).on('change', 'input.customfile', function () {
            var $this = $(this), uniqId = 'customfile_' + new Date().getTime(), $wrap = $this.parent(), $inputs = $wrap.siblings().find('.file-upload-input').filter(function () {
                    return !this.value;
                }), $file = $('<input type="file" id="' + uniqId + '" name="' + $this.attr('name') + '"/>');
            setTimeout(function () {
                if ($this.val()) {
                    if (!$inputs.length) {
                        $wrap.after($file);
                        $file.customFile();
                    }
                } else {
                    $inputs.parent().remove();
                    $wrap.appendTo($wrap.parent());
                    $wrap.find('input').focus();
                }
            }, 1);
        });
    }
}(jQuery));
$('input[type=file]').customFile();
//@ sourceURL=pen.js
</script>
	
</body>






</html>