package io

trait Requester[A,B] {

  def get(options:A):B

}
