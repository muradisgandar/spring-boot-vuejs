<template>
  <div class="container shopping-cart">
    <div class="content">
      <h3>Product Detail {{ $route.params.id }}</h3>

      <div class="row">
        <div class="col-md-12 col-lg-12">
          <div class="row">
            <div class="col-md-5">
              <image-carousel></image-carousel>
            </div>
            <div class="col-md-7">
              <features></features>
            </div>
          </div>
        </div>
        <hr>
      </div>

      <div class="row">
        <description></description>
      </div>

      <div class="row">
        <comments></comments>
      </div>
    </div>
  </div>


</template>

<script>
import ImageCarousel from "@/components/product-detail/image-carousel";
import Features from "@/components/product-detail/features";
import Description from "@/components/product-detail/description";
import Comments from "@/components/product-detail/comments";
export default {
  name: "ProductDetail",
  components: {Comments, Description, Features, ImageCarousel}
}
</script>

<style scoped>

</style>