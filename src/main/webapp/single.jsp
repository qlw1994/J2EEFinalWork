<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Single</title>
<link href="http://127.0.0.1:8080/ShopSite/resources/css/bootstrap.css" rel="stylesheet"
	type="text/css" media="all" />
<!--theme-style-->
<link href="http://127.0.0.1:8080/ShopSite/resources/css/mainstyle.css" rel="stylesheet"
	type="text/css" media="all" />
<link rel="stylesheet" href="http://127.0.0.1:8080/ShopSite/resources/css/etalage.css" type="text/css"
	media="all" />
<!--//theme-style-->
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<script type="application/x-javascript">
	 addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } 
</script>
<!--fonts-->
<link
	href='http://fonts.useso.com/css?family=Open+Sans:400,300,600,700,800'
	rel='stylesheet' type='text/css'>
<!--//fonts-->
<script src="http://127.0.0.1:8080/ShopSite/resources/js/jquery.min.js"></script>
<script src="http://127.0.0.1:8080/ShopSite/resources/js/jquery.easydropdown.js"></script>
<script src="http://127.0.0.1:8080/ShopSite/resources/js/jquery.etalage.min.js"></script>
<script>
	jQuery(document).ready(function($) {$('#etalage').etalage(
										{
											thumb_image_width : 300,
											thumb_image_height : 400,
											source_image_width : 900,
											source_image_height : 1200,
											show_hint : true,
											click_callback : function(
													image_anchor, instance_id) {
												alert('Callback example:\nYou clicked on an image with the anchor: "'
														+ image_anchor
														+ '"\n(in Etalage instance: "'
														+ instance_id + '")');
											}
										});

					});
</script>
<script type="text/javascript">
	$(document).ready(function() {
		var id = "${customer_id}";
		if (id != null && id != "") {
			var photo = "${photoURL}";
			if (photo != null && photo != "") {
				$("#headPhoto").attr('src', photo);
			} else {
				$("#headPhoto").attr('src', "resources/images/avatar.png");
			}
			$("#islogin").hide();
		} else {
			$("#headPhoto").hide();
		}

	})
	function addToCart(){
		$.ajax({
			 type: "GET",  
		        url: "http://127.0.0.1:8080/ShopSite/Single/AddToCart?gid=${goods.gid}",     
		        //json格式接收数据  
		        dataType: "text",  
		        success: function (res) { 
		        	if(res=="L"){
		        		window.location.href="http://127.0.0.1:8080/ShopSite/login.jsp";
		        	}
		        	
		        	else if(res!="0"){
		        	$("#goodsnumber").html("库存量: "+res+"");
		    		alert("添加成功 ,库存剩余"+res);
		    		}
		        	else{
		        		alert("库存不足！");
		        	}
		        } ,
		        error:function () { 
		        	alert("请求失败");
		        }
		});
	}
</script>
</head>
<body>
	<!--header-->
	<div class="header">
		<div class="top-header">
			<div class="container">
				<div class="top-header-left">
					<ul class="support">
						<li><a href="#"><label> </label></a></li>
						<li><a href="#">24x7 live<span class="live">
									support</span></a></li>
					</ul>
					<ul class="support">
						<li class="van"><a href="#"><label> </label></a></li>
						<li><img id="headPhoto" src="" width=32px height=30px /><a
							href="#">${customer_id}</a></li>
					</ul>
					<div class="clearfix"></div>
				</div>
				<div class="top-header-right">
					<div class="down-top">

						<select tabindex="4" class="dropdown">
							<option value="" class="label" value="">English</option>
							<option value="1">Japanese</option>
							<option value="2">French</option>
							<option value="3">German</option>
						</select>
					</div>
					<div class="down-top top-down">

						<select tabindex="4" class="dropdown ">
							<option value="" class="label" value="">Currency :USD</option>
							<option value="1">Dollar</option>
							<option value="2">Euro</option>
						</select>
					</div>
					<div class="clearfix"></div>
				</div>
				<div class="clearfix"></div>
			</div>
		</div>
		<div class="bottom-header">
			<div class="container">
				<div class="header-bottom-left">
					<div class="logo">
						<a href="http://127.0.0.1:8080/ShopSite/home.jsp"><img
							src="resources/images/logo.png" alt=" " /></a>
					</div>
					<div class="search">
						<input type="text" value="" onfocus="this.value = '';"
							onblur="if (this.value == '') {this.value = '';}"> <input
							type="submit" value="SEARCH">

					</div>
					<div class="clearfix"></div>
				</div>
				<div class="header-bottom-right">
					<ul class="men-grid">
						<li><a href="http://127.0.0.1:8080/ShopSite/MessageList"><span> </span>New Messages【${ctoread}】</a></li>
						<li>
						<li><a href="http://127.0.0.1:8080/ShopSite/GoodsList"><span>
							</span>Upload Goods</a></li>
						<li><a href="http://127.0.0.1:8080/ShopSite/AddressList"><span>
							</span>AddressList</a></li>
						<li><a
							href="http://127.0.0.1:8080/ShopSite/personalCenter.jsp"><span>
							</span>YOUR ACCOUNT</a></li>
						<li>
							<div id="islogin">
								<ul class="men-grid">
									<li class="login"><a
										href="http://127.0.0.1:8080/ShopSite/login.jsp"><span>
										</span>LOGIN</a></li>
									<li class="login"><a
										href="http://127.0.0.1:8080/ShopSite/register.jsp"><span></span>SIGNUP</a></li>
								</ul>
							</div>
						</li>
						<li class="cart"><a href="http://127.0.0.1:8080/ShopSite/ShopcartList"><span> </span>CART</a></li>
					</ul>
				</div>
				<div class="clearfix"></div>
			</div>
		</div>
	</div>
	<!---->

	<div class="container">

		<div class=" single_top">
			<div class="single_grid">
				<div class="grid images_3_of_2">
					<ul id="etalage">
						<li><img class="etalage_thumb_image"
							src="http://127.0.0.1:8080/ShopSite/${goods.gurl}" class="img-responsive" /> <img
							class="etalage_source_image" src="http://127.0.0.1:8080/ShopSite/${goods.gurl}" 
							class="img-responsive" title="" /></li>
						<li><img class="etalage_thumb_image"
							src="http://127.0.0.1:8080/ShopSite/${goods.gurl}" class="img-responsive" /> <img
							class="etalage_source_image" src="http://127.0.0.1:8080/ShopSite/${goods.gurl}" 
							class="img-responsive" title="" /></li>
						<li><img class="etalage_thumb_image"
							src="http://127.0.0.1:8080/ShopSite/${goods.gurl}" class="img-responsive" /> <img
							class="etalage_source_image" src="http://127.0.0.1:8080/ShopSite/${goods.gurl}" 
							class="img-responsive" /></li>
						<li><img class="etalage_thumb_image"
							src="http://127.0.0.1:8080/ShopSite/${goods.gurl}" class="img-responsive" /> <img
							class="etalage_source_image" src="http://127.0.0.1:8080/ShopSite/${goods.gurl}" 
							class="img-responsive" /></li>
					</ul>
					<div class="clearfix"></div>
				</div>
				<div class="desc1 span_3_of_2">
					<ul class="back">
						<li><i class="back_arrow"> </i>Back to <a
							href="http://127.0.0.1:8080/ShopSite/home.jsp">Women's
								Clothing</a></li>
					</ul>
					<h1>Sofi Blouse</h1>
					<ul class="price_single">
						<li class="head"><h2>$ ${goods.gprice}</h2></li>
						<li class="head_desc sky-form"><a href="#"><h4 id="goodsnumber">库存量: ${goods.gnumber}</h4></a>
							<fieldset>
								<section>

								<div class="rating">
									<input type="radio" name="stars-rating" id="stars-rating-5">
									<label for="stars-rating-5"><i class="icon-star"></i></label> <input
										type="radio" name="stars-rating" id="stars-rating-4">
									<label for="stars-rating-4"><i class="icon-star"></i></label> <input
										type="radio" name="stars-rating" id="stars-rating-3">
									<label for="stars-rating-3"><i class="icon-star"></i></label> <input
										type="radio" name="stars-rating" id="stars-rating-2">
									<label for="stars-rating-2"><i class="icon-star"></i></label> <input
										type="radio" name="stars-rating" id="stars-rating-1">
									<label for="stars-rating-1"><i class="icon-star"></i></label>

								</div>



								</section>
							</fieldset></li>
						<div class="clearfix"></div>
					</ul>
					<p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit,
						sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna
						aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud
						exerci tation ullamcorper suscipit lobortis nisl ut aliquip ex ea
						commodo consequat. Duis autem vel eum iriure dolor in hendrerit in
						vulputate velit esse molestie consequat, vel illum dolore eu
						feugiat nulla facilisis at vero eros et accumsan et iusto odio
						dignissim qui blandit praesent luptatum zzril delenit augue duis
						dolore te feugait nulla facilisi. Nam liber tempor cum soluta
						nobis eleifend option congue nihil imperdiet doming id quod mazim
						placerat facer possim assum</p>

					<a  class="now-get" onclick="addToCart()">Add To Cart</a>

				</div>
				<div class="clearfix"></div>
			</div>
			<ul id="flexiselDemo1">
				<li><img src="http://127.0.0.1:8080/ShopSite/resources/images/pi.jpg" />
					<div class="grid-flex">
						<a href="#">Bloch</a>
						<p>Rs 850</p>
					</div></li>
				<li><img src="http://127.0.0.1:8080/ShopSite/resources/images/pi1.jpg" />
					<div class="grid-flex">
						<a href="#">Capzio</a>
						<p>Rs 850</p>
					</div></li>
				<li><img src="http://127.0.0.1:8080/ShopSite/resources/images/pi2.jpg" />
					<div class="grid-flex">
						<a href="#">Zumba</a>
						<p>Rs 850</p>
					</div></li>
				<li><img src="http://127.0.0.1:8080/ShopSite/resources/images/pi3.jpg" />
					<div class="grid-flex">
						<a href="#">Bloch</a>
						<p>Rs 850</p>
					</div></li>
				<li><img src="http://127.0.0.1:8080/ShopSite/resources/images/pi4.jpg" />
					<div class="grid-flex">
						<a href="#">Capzio</a>
						<p>Rs 850</p>
					</div></li>
			</ul>
			<script type="text/javascript">
				$(window).load(function() {
					$("#flexiselDemo1").flexisel({
						visibleItems : 5,
						animationSpeed : 1000,
						autoPlay : true,
						autoPlaySpeed : 3000,
						pauseOnHover : true,
						enableResponsiveBreakpoints : true,
						responsiveBreakpoints : {
							portrait : {
								changePoint : 480,
								visibleItems : 1
							},
							landscape : {
								changePoint : 640,
								visibleItems : 2
							},
							tablet : {
								changePoint : 768,
								visibleItems : 3
							}
						}
					});

				});
			</script>
			<script type="text/javascript" src="http://127.0.0.1:8080/ShopSite/resources/js/jquery.flexisel.js"></script>

			<div class="toogle">
				<h3 class="m_3">Product Details</h3>
				<p class="m_text">Lorem ipsum dolor sit amet, consectetuer
					adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet
					dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam,
					quis nostrud exerci tation ullamcorper suscipit lobortis nisl ut
					aliquip ex ea commodo consequat. Duis autem vel eum iriure dolor in
					hendrerit in vulputate velit esse molestie consequat, vel illum
					dolore eu feugiat nulla facilisis at vero eros et accumsan et iusto
					odio dignissim qui blandit praesent luptatum zzril delenit augue
					duis dolore te feugait nulla facilisi. Nam liber tempor cum soluta
					nobis eleifend option congue nihil imperdiet doming id quod mazim
					placerat facer possim assum.</p>
			</div>
		</div>

		<!---->
		<div class="sub-cate">
			<div class=" top-nav rsidebar span_1_of_left">
				<h3 class="cate">CATEGORIES</h3>
				<ul class="menu">
					<li class="item1"><a href="#">Curabitur sapien<img
							class="arrow-img" src="resources/images/arrow1.png" alt="" />
					</a>
						<ul class="cute">
							<li class="subitem1"><a
								href="http://127.0.0.1:8080/ShopSite/product.jsp">Cute
									Kittens </a></li>
							<li class="subitem2"><a
								href="http://127.0.0.1:8080/ShopSite/product.jsp">Strange
									Stuff </a></li>
							<li class="subitem3"><a
								href="http://127.0.0.1:8080/ShopSite/product.jsp">Automatic
									Fails </a></li>
						</ul></li>
					<li class="item2"><a href="#">Dignissim purus <img
							class="arrow-img " src="resources/images/arrow1.png" alt="" /></a>
						<ul class="cute">
							<li class="subitem1"><a
								href="http://127.0.0.1:8080/ShopSite/product.jsp">Cute
									Kittens </a></li>
							<li class="subitem2"><a
								href="http://127.0.0.1:8080/ShopSite/product.jsp">Strange
									Stuff </a></li>
							<li class="subitem3"><a
								href="http://127.0.0.1:8080/ShopSite/product.jsp">Automatic
									Fails </a></li>
						</ul></li>
					<li class="item3"><a href="#">Ultrices id du<img
							class="arrow-img img-arrow" src="resources/images/arrow1.png"
							alt="" />
					</a>
						<ul class="cute">
							<li class="subitem1"><a
								href="http://127.0.0.1:8080/ShopSite/product.jsp">Cute
									Kittens </a></li>
							<li class="subitem2"><a
								href="http://127.0.0.1:8080/ShopSite/product.jsp">Strange
									Stuff </a></li>
							<li class="subitem3"><a
								href="http://127.0.0.1:8080/ShopSite/product.jsp">Automatic
									Fails</a></li>
						</ul></li>
					<li class="item4"><a href="#">Cras iacaus rhone <img
							class="arrow-img img-left-arrow"
							src="resources/images/arrow1.png" alt="" /></a>
						<ul class="cute">
							<li class="subitem1"><a
								href="http://127.0.0.1:8080/ShopSite/product.jsp">Cute
									Kittens </a></li>
							<li class="subitem2"><a
								href="http://127.0.0.1:8080/ShopSite/product.jsp">Strange
									Stuff </a></li>
							<li class="subitem3"><a
								href="http://127.0.0.1:8080/ShopSite/product.jsp">Automatic
									Fails </a></li>
						</ul></li>
					<li>
						<ul class="kid-menu">
							<li><a href="http://127.0.0.1:8080/ShopSite/product.jsp">Tempus
									pretium</a></li>
							<li><a href="http://127.0.0.1:8080/ShopSite/product.jsp">Dignissim
									neque</a></li>
							<li><a href="http://127.0.0.1:8080/ShopSite/product.jsp">Ornared
									id aliquet</a></li>
						</ul>
					</li>
					<ul class="kid-menu ">
						<li><a href="http://127.0.0.1:8080/ShopSite/product.jsp">Commodo
								sit</a></li>
						<li><a href="http://127.0.0.1:8080/ShopSite/product.jsp">Urna
								ac tortor sc</a></li>
						<li><a href="http://127.0.0.1:8080/ShopSite/product.jsp">Ornared
								id aliquet</a></li>
						<li><a href="http://127.0.0.1:8080/ShopSite/product.jsp">Urna
								ac tortor sc</a></li>
						<li><a href="http://127.0.0.1:8080/ShopSite/product.jsp">Eget
								nisi laoreet</a></li>
						<li><a href="http://127.0.0.1:8080/ShopSite/product.jsp">Faciisis
								ornare</a></li>
						<li class="menu-kid-left"><a href="contact.jsp">Contact
								us</a></li>
					</ul>

				</ul>
			</div>
			<!--initiate accordion-->
			<script type="text/javascript">
				$(function() {
					var menu_ul = $('.menu > li > ul'), menu_a = $('.menu > li > a');
					menu_ul.hide();
					menu_a.click(function(e) {
						e.preventDefault();
						if (!$(this).hasClass('active')) {
							menu_a.removeClass('active');
							menu_ul.filter(':visible').slideUp('normal');
							$(this).addClass('active').next().stop(true, true)
									.slideDown('normal');
						} else {
							$(this).removeClass('active');
							$(this).next().stop(true, true).slideUp('normal');
						}
					});

				});
			</script>
			<div class=" chain-grid menu-chain">
				<a href="http://127.0.0.1:8080/ShopSite/single.jsp"><img
					class="img-responsive chain" src="resources/images/wat.jpg" alt=" " /></a>
				<div class="grid-chain-bottom chain-watch">
					<span class="actual dolor-left-grid">300$</span> <span
						class="reducedfrom">500$</span>
					<h6>Lorem ipsum dolor</h6>
				</div>
			</div>
			<a class="view-all all-product"
				href="http://127.0.0.1:8080/ShopSite/product.jsp">VIEW ALL
				PRODUCTS<span> </span>
			</a>
		</div>
		<div class="clearfix"></div>
	</div>
	<!---->
	<div class="footer">
		<div class="footer-top">
			<div class="container">
				<div class="latter">
					<h6>NEWS-LATTER</h6>
					<div class="sub-left-right">
						<form>
							<input type="text" value="Enter email here"
								onfocus="this.value = '';"
								onblur="if (this.value == '') {this.value = 'Enter email here';}" />
							<input type="submit" value="SUBSCRIBE" />
						</form>
					</div>
					<div class="clearfix"></div>
				</div>
				<div class="latter-right">
					<p>FOLLOW US</p>
					<ul class="face-in-to">
						<li><a href="#"><span> </span></a></li>
						<li><a href="#"><span class="facebook-in"> </span></a></li>
						<div class="clearfix"></div>
					</ul>
					<div class="clearfix"></div>
				</div>
				<div class="clearfix"></div>
			</div>
		</div>
		<div class="footer-bottom">
			<div class="container">
				<div class="footer-bottom-cate">
					<h6>CATEGORIES</h6>
					<ul>
						<li><a href="#">Curabitur sapien</a></li>
						<li><a href="#">Dignissim purus</a></li>
						<li><a href="#">Tempus pretium</a></li>
						<li><a href="#">Dignissim neque</a></li>
						<li><a href="#">Ornared id aliquet</a></li>
						<li><a href="#">Ultrices id du</a></li>
						<li><a href="#">Commodo sit</a></li>
						<li><a href="#">Urna ac tortor sc</a></li>
						<li><a href="#">Ornared id aliquet</a></li>
						<li><a href="#">Urna ac tortor sc</a></li>
						<li><a href="#">Eget nisi laoreet</a></li>
						<li><a href="#">Faciisis ornare</a></li>
					</ul>
				</div>
				<div class="footer-bottom-cate bottom-grid-cat">
					<h6>FEATURE PROJECTS</h6>
					<ul>
						<li><a href="#">Curabitur sapien</a></li>
						<li><a href="#">Dignissim purus</a></li>
						<li><a href="#">Tempus pretium</a></li>
						<li><a href="#">Dignissim neque</a></li>
						<li><a href="#">Ornared id aliquet</a></li>
						<li><a href="#">Ultrices id du</a></li>
						<li><a href="#">Commodo sit</a></li>
					</ul>
				</div>
				<div class="footer-bottom-cate">
					<h6>TOP BRANDS</h6>
					<ul>
						<li><a href="#">Curabitur sapien</a></li>
						<li><a href="#">Dignissim purus</a></li>
						<li><a href="#">Tempus pretium</a></li>
						<li><a href="#">Dignissim neque</a></li>
						<li><a href="#">Ornared id aliquet</a></li>
						<li><a href="#">Ultrices id du</a></li>
						<li><a href="#">Commodo sit</a></li>
						<li><a href="#">Urna ac tortor sc</a></li>
						<li><a href="#">Ornared id aliquet</a></li>
						<li><a href="#">Urna ac tortor sc</a></li>
						<li><a href="#">Eget nisi laoreet</a></li>
						<li><a href="#">Faciisis ornare</a></li>
					</ul>
				</div>
				<div class="footer-bottom-cate cate-bottom">
					<h6>OUR ADDERSS</h6>
					<ul>
						<li>Aliquam metus dui.</li>
						<li>orci, ornareidquet</li>
						<li>ut,DUI.</li>
						<li>nisi, dignissim</li>
						<li>gravida at.</li>
						<li class="phone">PH : 6985792466</li>
						<li class="temp">
							<p class="footer-class">
								Copyright &copy; 2015.Company name All rights reserved.<a
									target="_blank" href="http://www.sucai888.com/moban/">&#x7F51;&#x9875;&#x6A21;&#x677F;</a>
							</p>
						</li>
					</ul>
				</div>
				<div class="clearfix"></div>
			</div>
		</div>
	</div>
	<div style="display: none">
		<script src='http://v7.cnzz.com/stat.php?id=155540&web_id=155540'
			language='JavaScript' charset='utf-8'></script>
	</div>
</body>
</html>